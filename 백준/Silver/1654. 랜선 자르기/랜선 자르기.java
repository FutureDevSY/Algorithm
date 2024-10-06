import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      static long[] wires;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K, N;
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());     //주어진 랜선 개수
            N = Integer.parseInt(st.nextToken());     //만들어야 할 랜선의 길이
            //K == N일수도 있음!

            wires = new long[K];
            long longest = -1;
            for (int i = 0; i < wires.length; i++) {
                  wires[i] = Integer.parseInt(br.readLine());
                  longest = Math.max(longest, wires[i]);
            }

            long l = 1;
            long r = longest;
            long m = (l + r) / 2;
            long tmpCnt = 0;
            long maxLng = -1;

            while(l <= r){
                  tmpCnt = countWires(m);
                  if(tmpCnt >= N){
                        maxLng = Math.max(maxLng, m);
                        l = m + 1;
                  }else if(tmpCnt < N){
                       r = m - 1;
                  }
                  m = (l + r) / 2;

            }

            System.out.println(maxLng);

      }
      private static long countWires(long lng){
            long sum = 0;
            for (int i = 0; i < wires.length; i++) {
                  sum += wires[i] / lng;
            }
            return sum;
      }

}
