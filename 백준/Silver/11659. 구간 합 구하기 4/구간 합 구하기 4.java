import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, M;   //수의 개수, 합을 구할 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[] nums = new int[N];
            int[] numSum = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  nums[i] = Integer.parseInt(st.nextToken());
                  if(i == 0) numSum[i] = nums[i];
                  else numSum[i] = nums[i] + numSum[i - 1];
            }

            int a, b;
            for(int i=0; i<M; i++){
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken()) - 1;
                  b = Integer.parseInt(st.nextToken()) - 1;
                  if(a == 0){
                        System.out.println(numSum[b]);
                  }else{
                        System.out.println(numSum[b] - numSum[a - 1]);
                  }

            }
      }

}
