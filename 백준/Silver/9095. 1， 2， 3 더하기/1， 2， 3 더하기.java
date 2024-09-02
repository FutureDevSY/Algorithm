import java.io.*;
import java.util.StringTokenizer;

public class Main {  //백준 9095번 1 2 3 더하기 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11]; //인덱스 0은 안쓸거임
        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
        int result;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());    //n은 0~10
            if (n > 3) {
                for (int j = 4; j <= n; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
            }
            bw.write(Integer.toString(dp[n]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
