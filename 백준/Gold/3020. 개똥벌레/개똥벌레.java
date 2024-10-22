import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, H;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[] up = new int[N / 2];
            int[] down = new int[N / 2];

            int dCnt = 0;
            int uCnt = 0;
            for(int i=0; i<N; i++){
                  if(i != 1 && i % 2 == 0){
                        down[dCnt++] = Integer.parseInt(br.readLine());
                  }else{
                        up[uCnt++] = Integer.parseInt(br.readLine());
                  }
            }

            Arrays.sort(up);
            Arrays.sort(down);

            int tmp = 0;
            int minBreak = Integer.MAX_VALUE;
            int minCnt = 0;
            for(int i=1; i<=H; i++){
                  tmp =
                      lowerBound(0, up.length, up, i) +
                          lowerBound(0, down.length, down,H - i + 1);
                  if(tmp < minBreak){
                        minBreak = tmp;
                        minCnt = 1;
                  }else if(tmp == minBreak) minCnt++;
            }

            System.out.println(minBreak + " " + minCnt);


      }

      static int lowerBound(int left, int right, int[] arr, int height){
            int mid = 0;
            while(left < right){
                  mid = (left + right) / 2;
                  if(arr[mid] < height) left = mid + 1;
                  else right = mid;
            }
            return arr.length - left;
      }

}
