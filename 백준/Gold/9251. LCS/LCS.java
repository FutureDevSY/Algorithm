
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String strA = br.readLine();
            String strB = br.readLine();

            int aLng = strA.length();
            int bLng = strB.length();
           
            int[][] dp = new int[bLng + 1][aLng + 1];

            for (int i = 1; i <= bLng; i++) {
                  char chrB = strB.charAt(i-1);

                  for (int j = 1; j <= aLng; j++) {
                        char chrA = strA.charAt(j-1);
                        if(chrA == chrB) {
                              dp[i][j] = dp[i - 1][j - 1] + 1;
                        }else{
                              dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        }
                  }
            }

            System.out.println(dp[bLng][aLng]);

            

      }

}
