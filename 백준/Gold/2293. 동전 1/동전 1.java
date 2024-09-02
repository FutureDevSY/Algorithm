import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n, k;
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[] values = new int[n];

            for (int i = 0; i < n; i++) {
                  values[i] = Integer.parseInt(br.readLine());
            }
            
            int[] dp = new int[k + 1];
            dp[0] = 1;

            for (int i = 0; i < n; i++) {
                  for (int j = 1; j <= k; j++) {
                        if(j - values[i] < 0) continue;
                        dp[j] = dp[j - values[i]] + dp[j];
                  }
            }

            System.out.println(dp[k]);

      }


}
