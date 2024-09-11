import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      static int[] parent;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());       //점의 개수
            int M = Integer.parseInt(st.nextToken());       //턴수

            parent = new int[N];
            int a, b;
            int result = 0;
            //초기화
            for (int i = 0; i < N; i++) {
                  parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());
                  if(union(a, b)) {
                        result = i + 1;
                        break;
                  }
            }
            System.out.println(result);
      }

      private static int find(int node){
            //루트노드 탐색
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
      }

      private static boolean union(int nodeA, int nodeB){
            int ar = find(nodeA);
            int br = find(nodeB);

            if(ar == br) return true;     //사이클
            //기존에 부모가 정해진쪽이 있다면 그쪽을 부모노드로 삼는다
            else if(nodeA == ar && nodeB != br) parent[ar] = br;
            else parent[br] = ar;
            return false;
      }
}
