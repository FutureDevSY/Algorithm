import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int[] seq = new int[N];
            int[] LIS = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  seq[i] = Integer.parseInt(st.nextToken());
            }

            LIS[0] = seq[0];
            int lngOfLIS = 1;

            for (int i = 1; i < N; i++) {
                  int val = seq[i];
                  if(LIS[lngOfLIS - 1] < val){
                        lngOfLIS++;
                        LIS[lngOfLIS - 1] = val;
                  }else{
                        //lower bound 이분탐색 진행
                        int l = 0;
                        int r = lngOfLIS - 1;
                        while(l <= r){
                              int m = (l + r) / 2;

                              if(LIS[m] < val){
                                    l = m + 1;
                              }else{
                                    r = m - 1;
                              }
                        }
                        LIS[l] = val;
                  }
            }

            System.out.println(lngOfLIS);
      }

}
