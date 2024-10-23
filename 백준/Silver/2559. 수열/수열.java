import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, K;
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] intArr = new int[N + 1];
            int[] preSum = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                  intArr[i] = Integer.parseInt(st.nextToken());
                  preSum[i] = intArr[i] + preSum[i - 1];
            }

            int[] resArr = new int[N + 1];
            for (int i = K + 1; i <= N; i++) {
                  resArr[i] = preSum[i] - preSum[i - K];
            }
            resArr[K] = preSum[K];
            int maxInt = Integer.MIN_VALUE;
            for (int i = K; i <= N; i++) {
                  maxInt = Math.max(maxInt, resArr[i]);
            }

            System.out.println(maxInt);



      }
}
