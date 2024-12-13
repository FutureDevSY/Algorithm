import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
      static int N, M;
      static int[][] map;
      static int[][] val;
      static int startX = 0;
      static int startY = 0;

      static class Pair{
            int x;
            int y;
            int val;

            Pair(int x, int y, int val){
                  this.x = x;
                  this.y = y;
                  this.val = val;
            }
      }

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //세로
            M = Integer.parseInt(st.nextToken()); //가로
            map = new int[N][M];
            val = new int[N][M];

            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < M; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                        if(map[i][j] == 2){
                              startX = i;
                              startY = j;
                        }
                  }
            }

            bfs();

            for(int i=0; i<N; i++){
                  for (int j=0; j<M ; j++) {
                        if(map[i][j] == 1 && val[i][j] == 0){ //1인 땅인데 도달할수 없는 경우라면
                              bw.write("-1" + " ");
                        }else{
                              bw.write(val[i][j] + " ");
                        }

                  }
                  bw.write('\n');
            }

            bw.flush();
            bw.close();
      }

      static int[] dirx = {-1, 0, 1, 0};
      static int[] diry = {0, 1, 0, -1};
      private static void bfs(){
            boolean[][] visited = new boolean[N][M];
            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(startX, startY, 0));
            visited[startX][startY] = true;

            Pair curPair;
            int nextX, nextY;
            while(!queue.isEmpty()){
                  curPair = queue.poll();
                  for (int i = 0; i < 4; i++) {
                        nextX = curPair.x + dirx[i];
                        nextY = curPair.y + diry[i];
                        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY]) continue;
                        if(map[nextX][nextY] == 0) continue;
                        queue.add(new Pair(nextX, nextY, curPair.val + 1));
                        visited[nextX][nextY] = true;
                        val[nextX][nextY] = curPair.val + 1;
                  }
            }
      }

}
