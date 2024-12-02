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

            int[][] map = new int[N][M];
            String str;
            int maxSize = 0;
            for (int i = 0; i < N; i++) {
                  str = br.readLine();
                  for (int j = 0; j < M; j++) {
                        map[i][j] = str.charAt(j) - '0';
                        if(maxSize == 0 && map[i][j] == 1) maxSize = 1;
                  }
            }

            int valA, valB, valC;
            int minVal = 0;


            for (int i = 1; i < N; i++) {
                  for (int j = 1; j < M; j++) {
                        valA = map[i - 1][j];
                        valB = map[i - 1][j - 1];
                        valC = map[i][j - 1];
                        minVal = Math.min(valA, Math.min(valB, valC));
                        if(map[i][j] != 0){
                              map[i][j] = minVal + 1;
                              maxSize = Math.max(maxSize, minVal + 1);
                        }

                  }
            }

            System.out.println(maxSize * maxSize);
      }

}
