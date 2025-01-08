import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //아이들의 수
            int M = Integer.parseInt(st.nextToken()); //색상의 수

            int[] jewels = new int[M];
            int minCnt = Integer.MAX_VALUE;
            int maxCnt = Integer.MIN_VALUE;
            for (int i = 0; i < M; i++) {
                  jewels[i] = Integer.parseInt(br.readLine());
                  minCnt = Math.min(minCnt, jewels[i]);
                  maxCnt = Math.max(maxCnt, jewels[i]);
            }

            int l = 1;
            int r = 1000000000;
            int m = 0;
            int jealous = Integer.MAX_VALUE;
            int tmpCnt = 0;

            while (l <= r) {
                  m = (l + r) / 2;
                  tmpCnt = 0;
                  for (int i = 0; i < jewels.length; i++) {
                        tmpCnt += jewels[i] / m;
                        if(jewels[i] % m > 0) tmpCnt++;
                  }

                  //보석이 남는다면
                  if(tmpCnt > N){
                        l = m + 1;
                  }
                  else{
                        jealous = Math.min(jealous, m);
                        r = m - 1;
                  }
            }

            System.out.println(jealous);

      }

}
