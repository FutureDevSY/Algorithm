import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            int N;
            int[][] dp;

            for (int t = 0; t < T; t++) {
                  N = Integer.parseInt(br.readLine());
                  dp = new int[4][N + 1];

                  for(int i=1; i<=3; i++){
                        for (int j = 1; j <= N; j++) {
                              if(i == j) dp[i][j] = dp[i - 1][j] + 1;
                              else if(j > i) dp[i][j] = dp[i][j - i] + dp[i - 1][j];
                              else dp[i][j] = dp[i - 1][j];
                        }
                  }
                  System.out.println(dp[3][N]);
            }
      }

}
