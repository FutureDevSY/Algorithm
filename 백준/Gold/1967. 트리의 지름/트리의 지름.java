import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
      static int maxVal = -1;
      static ArrayList<Integer[]>[] tree;
      static boolean[] visited;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 0; i < tree.length; i++) {
                  tree[i] = new ArrayList<>();
            }
            StringTokenizer st;
            int cur, child, val;
            String input;
            while((input = br.readLine()) != null && !input.isEmpty()) {
                  st = new StringTokenizer(input);
                  cur = Integer.parseInt(st.nextToken());
                  child = Integer.parseInt(st.nextToken());
                  val = Integer.parseInt(st.nextToken());

                  tree[cur].add(new Integer[] {child, val});
                  tree[child].add(new Integer[] {cur, val});
            }

            for(int i=1; i< tree.length; i++){
                  Arrays.fill(visited, false);
                  dfs(i, 0);
            }

            System.out.println(maxVal);
      }

      public static void dfs(int node, int sumVal){
            visited[node] = true;
            maxVal = Math.max(maxVal, sumVal);
            int nextnode;
            for (int i = 0; i < tree[node].size(); i++) {
                  nextnode = tree[node].get(i)[0];
                  if(!visited[nextnode]){
                        dfs(nextnode, sumVal + tree[node].get(i)[1]);
                        visited[nextnode] = true;
                  }

            }

      }

}
