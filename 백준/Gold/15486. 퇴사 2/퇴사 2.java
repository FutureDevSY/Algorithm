import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int[][] days = new int[N + 2][2];   //각 날짜에 시작하는 상담의 기간/금액
            int[] dp = new int[N + 2];
            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                  st = new StringTokenizer(br.readLine());
                  days[i][0] = Integer.parseInt(st.nextToken());
                  days[i][1] = Integer.parseInt(st.nextToken());
            }

            int maxValue = 0;
            for (int i = 1; i <= N + 1; i++) {
                  maxValue = Math.max(maxValue, dp[i]);

                  if(days[i][0] + i <= N + 1){
                        dp[days[i][0] + i] = Math.max(dp[days[i][0] + i], maxValue + days[i][1]);
                  }
                  maxValue = Math.max(maxValue, dp[i]);
            }

            System.out.println(maxValue);

      }

}
