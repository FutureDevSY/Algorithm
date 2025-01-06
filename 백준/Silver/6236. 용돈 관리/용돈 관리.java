import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //  N일동안
            int M = Integer.parseInt(st.nextToken()); // M번 인출
            int[] plan = new int[N];
            int max = -1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                  plan[i] = Integer.parseInt(br.readLine());
                  max = Math.max(max, plan[i]);
                  sum += plan[i];
            }

            int left = max;
            int right = sum + 1;
            int mid = -1;
            int result;
            int answer = Integer.MAX_VALUE;
            while(left < right){
                  mid = (left + right) / 2;
                  result = calc(mid, N, plan);

                  if(result <= M){
                        answer = Math.min(answer, mid);
                        right = mid;
                  }else{
                        left = mid + 1;
                  }
            }

            System.out.println(answer);
      }

      private static int calc(int x, int N, int[] plan){
            int cnt = 0;
            int left = 0;
            for (int i = 0; i < N; i++) {
                  if (left < plan[i]){
                        cnt++;
                        left = x - plan[i];
                  }else{
                        left -= plan[i];
                  }
            }
            return cnt;
      }

}
