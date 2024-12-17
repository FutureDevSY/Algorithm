import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static int N;
      static int[][] ableToVisit;
      static ArrayList<Integer>[] al;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            ableToVisit = new int[N][N];
            al = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                  al[i] = new ArrayList<>();
            }

            StringTokenizer st;
            int a;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < N; j++) {
                        a = Integer.parseInt(st.nextToken());
                        if(a == 1){
                              al[i].add(j);
                        }
                  }
            }

            // i에서 갈수 있는 경로들 파악하기
            for (int i = 0; i < N; i++) {
                  int[] bfsArr = bfs(i);
                  for (int x : bfsArr) {
                        bw.write(x + " ");
                  }
                  bw.write('\n');
            }

            bw.close();
      }

      static int[] bfs(int x){
            int[] visit = new int[N];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(x);
//            visit[x] = 1;

            int cur;
            int next;
            while (!queue.isEmpty()) {
                  cur = queue.poll();

                  for (int i = 0; i < al[cur].size(); i++) {
                        next = al[cur].get(i);
                        if(visit[next] == 1) continue;
                        queue.add(next);
                        visit[next] = 1;
                  }
            }
            return visit;
      }

}
