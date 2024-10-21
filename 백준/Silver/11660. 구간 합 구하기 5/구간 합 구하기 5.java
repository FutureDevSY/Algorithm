import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] nums = new int[N + 1][N + 1];
            int[][] sumNums = new int[N + 1][N + 1];

            for(int i=1; i<=N; i++){
                  st = new StringTokenizer(br.readLine());
                  for (int j = 1; j <= N; j++) {
                        sumNums[i][j] = Integer.parseInt(st.nextToken());
                        sumNums[i][j] += sumNums[i - 1][j];
                        sumNums[i][j] += sumNums[i][j - 1];
                        sumNums[i][j] -= sumNums[i - 1][j - 1];
                  }
            }

            int sx, sy, ex, ey;
            int result;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  sx = Integer.parseInt(st.nextToken());
                  sy = Integer.parseInt(st.nextToken());
                  ex = Integer.parseInt(st.nextToken());
                  ey = Integer.parseInt(st.nextToken());

                  result = sumNums[ex][ey] - (sumNums[ex][sy - 1]
                      + sumNums[sx - 1][ey] - sumNums[sx - 1][sy - 1]);
                  System.out.println(result);

            }
      }

}
