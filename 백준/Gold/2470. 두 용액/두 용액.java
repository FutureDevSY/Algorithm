import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] liquids = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                  liquids[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(liquids);

            int alcIdx = 0;
            int acidIdx = liquids.length - 1;
            int min = Integer.MAX_VALUE;  //여태까지 구한 0과의 가장 작은 거리
            int tmpAbs, tmp;
            int alc = 0;
            int acid = 0;
            while (alcIdx < acidIdx){
                  tmp = liquids[alcIdx] + liquids[acidIdx];
                  tmpAbs = Math.abs(tmp);
                  if(tmpAbs < min) {
                        min = tmpAbs;
                        alc =  liquids[alcIdx];
                        acid = liquids[acidIdx];

                  }
                  if(tmp == 0) break;
                  if(tmp < 0) alcIdx++;
                  else if(tmp > 0) acidIdx--;
            }

            System.out.println(alc + " " + acid);
      }
}
