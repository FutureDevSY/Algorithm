import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            long[] longArr = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  longArr[i] = Integer.parseInt(st.nextToken());
            }

            int left = 0;
            int right = N - 1;
            long curVal, curValAbs;
            long bestVal = Long.MAX_VALUE;
            long[] pair = new long[2];
            while(left < right){
                  curVal = longArr[left] + longArr[right];
                  curValAbs = Math.abs(curVal);
                  if(curValAbs < bestVal){
                        bestVal = Math.min(bestVal, curValAbs);
                        pair[0] = longArr[left];
                        pair[1] = longArr[right];
                  }
                  if(curVal == 0){
                        break;
                  }else if(curVal > 0){
                        right--;
                  }else if(curVal < 0){
                        left++;
                  }
            }

            System.out.println(pair[0] + " " + pair[1]);
      }

}
