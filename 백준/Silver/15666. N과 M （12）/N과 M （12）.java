import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static int[] arr;
      static int N, M;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            permutation(0, M, new int[M], 0);

      }

      static void permutation(int cnt, int M, int[] selected, int lastIdx){
            if(cnt >= M){
                  for(int i : selected){
                        System.out.print(i + " ");
                  }
                  System.out.println();
                  return;
            }
            int lastSelected = -1;
            for (int i = lastIdx; i < N; i++) {
                  if(arr[i] == lastSelected) continue;

                  selected[cnt] = arr[i];
                  lastSelected = arr[i];
                  permutation(cnt + 1, M, selected, i);
            }
      }

}
