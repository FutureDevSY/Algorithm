import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, H;   //길이, 높이
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[] bottom = new int[H + 2];      //석순
            int[] top = new int[H + 2];         //종유석
            int tmpA, tmpB;
            for (int i = 0; i < N/2; i++) {
                  tmpA = Integer.parseInt(br.readLine());
                  tmpB = Integer.parseInt(br.readLine());
                  bottom[tmpA] = bottom[tmpA] + 1;
                  top[H - tmpB + 1] = top[H - tmpB + 1] + 1;
            }
            
            int[] preSum = new int[H + 2];
            for (int i = H; i >= 1; i--) {
                  bottom[i] = bottom[i + 1] + bottom[i];
            }

            for (int i = 1; i <= H; i++) {
                  top[i] = top[i - 1] + top[i];
            }

            int minBreakCnt = 0;
            int minBreak = Integer.MAX_VALUE;
            for (int i=1; i<=H; i++) {
                  if(minBreak > bottom[i] + top[i]){
                        minBreak = bottom[i] + top[i];
                        minBreakCnt = 1;
                  }else if(minBreak == bottom[i] + top[i]){
                        minBreakCnt++;
                  }
            }

            System.out.println(minBreak + " " + minBreakCnt);
      }


}
