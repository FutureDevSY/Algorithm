import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  //    수열 총 길이
            int K = Integer.parseInt(st.nextToken());  //    같은 원소가 K개 넘으면 안됨
            st = new StringTokenizer(br.readLine());
            int[] intArr = new int[N];
            int maxInt = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                  intArr[i] = Integer.parseInt(st.nextToken());
                  maxInt = Math.max(maxInt, intArr[i]);
            }
            int[] cntArr = new int[maxInt + 1];

            int start = 0;
            int end = N - 1;
            int maxLng = Integer.MIN_VALUE;
            int tmpLng = 0;
            for (int i = 0; i < N; i++) {
                  cntArr[intArr[i]]++;

                  if(cntArr[intArr[i]] > K){
                        maxLng = Math.max(maxLng, i - start);
                        while(true){
                              cntArr[intArr[start]]--;
                              start++;
                              if(cntArr[intArr[i]] <= K) break;
                        }
                  }
            }

            maxLng = Math.max(maxLng, N - start);

            if(start == 0) System.out.println(N);
            else System.out.println(maxLng);



      }

}
