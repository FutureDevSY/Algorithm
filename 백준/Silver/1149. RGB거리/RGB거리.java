import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] minCostSum = new int[3];

            st = new StringTokenizer(br.readLine());
            minCostSum[0] = Integer.parseInt(st.nextToken());
            minCostSum[1] = Integer.parseInt(st.nextToken());
            minCostSum[2] = Integer.parseInt(st.nextToken());

            int r, g, b = 0;
            int tmpA, tmpB, tmpC = 0;
            for(int i=0; i<N-1; i++){
                  st = new StringTokenizer(br.readLine());
                  r = Integer.parseInt(st.nextToken());
                  g = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());

//                        r을 선택할 경우
                  tmpA = Math.min(minCostSum[1] + r, minCostSum[2] + r);
//                        g를 선택할 경우
                  tmpB = Math.min(minCostSum[0] + g, minCostSum[2] + g);
//                        b를 선택할 경우
                  tmpC = Math.min(minCostSum[0] + b, minCostSum[1] + b);

                  minCostSum[0] = tmpA;
                  minCostSum[1] = tmpB;
                  minCostSum[2] = tmpC;

            }

            System.out.println(Math.min(Math.min(minCostSum[0], minCostSum[1]), minCostSum[2]));
      }

}
