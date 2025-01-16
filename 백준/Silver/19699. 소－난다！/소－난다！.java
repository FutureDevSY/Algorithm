import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
      public static int N, M;
      public static int[] weight;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 소들의 수
            M = Integer.parseInt(st.nextToken()); //선별할 소의 수
            weight = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  weight[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] checked = new boolean[N];
            dfs(0, 0, 0, checked);
            Collections.sort(list);
            
            if(list.isEmpty()) System.out.print(-1);
            for (int x : list) {
                  System.out.print(x + " ");
            }

      }

      static ArrayList<Integer> list = new ArrayList<>();

      private static void dfs(int count, int sum, int start, boolean[] checked){
            if(count >= M){
                  if(!list.contains(sum) && isPrime(sum)){
                        list.add(sum);
                  }
                  return;
            }

            for (int i = start; i < N; i++) {
                  dfs(count + 1, sum + weight[i], i + 1, checked);
            }
      }

      public static boolean isPrime(int sum){
            if(sum == 1) return false;

            boolean result = true;
            for (int i = 1; i < sum; i++) {
                  if(i == 1 || i == sum) continue;
                  if(sum % i == 0){
                        result = false;
                        break;
                  }
            }
            return result;
      }

}
