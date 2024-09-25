import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      static int N;
      static int[][][] dp;
      static int[][] map;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            dp = new int[3][N + 2][N + 2];
            map = new int[N + 2][N + 2];

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 1; j <= N; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            dp[0][1][1] = 1;
            dp[0][1][2] = 1;

            // 0: 가로 / 1: 대각선 / 2: 새로
            for(int i=1; i<=N; i++){
                  for(int j=3; j<=N; j++){
                        if(map[i][j] == 1) continue;
                        if((i == 1 && j == 1) || (i == 1 && j == 2)) continue;
                        dp[0][i][j] = dp[0][i][j - 1] + dp[1][i][j - 1];
                        if(map[i - 1][j] != 1 && map[i][j - 1] != 1){
                              dp[1][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
                        }
                        dp[2][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
                  }
            }

            System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);

      }

}
