import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static class Node{
            int x;
            int y;
            char val;

            public Node(int x, int y, char val){
                  this.x = x;
                  this.y = y;
                  this.val = val;
            }
      }
      static int N;
      static boolean[][] visited;
      static char[][] map;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            map = new char[N][N];
            visited = new boolean[N][N];
            String str;
            for (int i = 0; i < N; i++) {
                  str = br.readLine();
                  for (int j = 0; j < N; j++) {
                        map[i][j] = str.charAt(j);
                  }
            }

            //적록색약이 아닌 사람의 경우
            int cntA = 0;
            for (int i = 0; i < N; i++) {
                  for (int j = 0; j < N; j++) {
                        if(!visited[i][j]){
                              cntA++;
                              bfs(false, map[i][j], i, j);
                        }

                  }
            }

            visited = new boolean[N][N];

            //적록색약의 경우
            int cntB = 0;
            for (int i = 0; i < N; i++) {
                  for (int j = 0; j < N; j++) {
                        if(!visited[i][j]){
                              cntB++;
                              bfs(true, map[i][j], i, j);
                        }

                  }
            }

            System.out.println(cntA + " " + cntB);
      }

      static int[] dirx = {0, 1, 0, -1};
      static int[] diry = {-1, 0, 1, 0};
      static void bfs(boolean isBlind, char chr, int x, int y){
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(x, y, chr));
            visited[x][y] = true;

            Node tmpChr;
            int nx, ny;
            while (!queue.isEmpty()) {
                  tmpChr = queue.poll();
                  for (int i = 0; i < 4; i++) {
                        nx = tmpChr.x + dirx[i];
                        ny = tmpChr.y + diry[i];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                        if(!isBlind){
                              if(map[nx][ny] != chr) continue;
                        }else{
                              if(chr == 'B'){
                                    if(map[nx][ny] != chr) continue;
                              }else{
                                    if(map[nx][ny] == 'B') continue;
                              }
                        }

                        queue.add(new Node(nx, ny, chr));
                        visited[nx][ny] = true;
                  }
            }
      }

}
