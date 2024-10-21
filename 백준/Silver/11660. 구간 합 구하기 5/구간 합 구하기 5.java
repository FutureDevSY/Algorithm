import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] sumArr = new int[N + 1][N + 1];
            int[][] nums = new int[N + 1][N + 1];

            for(int i=1; i<=N; i++){
                  st = new StringTokenizer(br.readLine());
                  for(int j=1; j<=N; j++){
                        nums[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            for(int i=1; i<=N; i++){
                  for(int j=1; j<=N; j++){
                        sumArr[j][i] = nums[j][i] + sumArr[j-1][i];
                  }
            }

            int sx, sy;
            int ex, ey;
            int sum = 0;
            for(int i=0; i<M; i++){
                  st = new StringTokenizer(br.readLine());

                  sx = Integer.parseInt(st.nextToken());
                  sy = Integer.parseInt(st.nextToken());
                  ex = Integer.parseInt(st.nextToken());
                  ey = Integer.parseInt(st.nextToken());

                  sum = 0;
                  for(int j=sy; j<=ey; j++){
                        sum += sumArr[ex][j];
                  }
                  for(int j=sy; j<=ey; j++){
                        sum -= sumArr[sx - 1][j];
                  }

                  System.out.println(sum);
            }


      }

}
