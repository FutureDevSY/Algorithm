import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, K;   //동전 종류, 가치의 합
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                  coins[i] = Integer.parseInt(br.readLine());
            }

            int cnt = 0;
            int mok, left;
            for (int i = N - 1; i >= 0; i--) {
                  mok = K / coins[i];
                  left = K % coins[i];
                  if(mok > 0){
                        cnt += mok;
                        K = left;
                  }
                  if(K == 0) break;
            }

            System.out.println(cnt);
      }

}
