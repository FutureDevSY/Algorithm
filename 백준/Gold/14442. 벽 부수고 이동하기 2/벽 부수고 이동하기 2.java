import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static class Pair {
            int x;
            int y;
            int dist; // 이동 거리
            int count; // 벽을 부순 횟수

            Pair(int x, int y, int dist, int count){
                  this.x = x;
                  this.y = y;
                  this.dist = dist;
                  this.count = count;
            }
      }

      static int N, M, K;
      static int[][] origin;
      static int minCnt = -1;  // 초기값 -1로 설정하여 도달하지 못할 경우 처리

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            origin = new int[N][M];

            for (int i = 0; i < N; i++) {
                  String str = br.readLine();
                  for (int j = 0; j < M; j++) {
                        origin[i][j] = str.charAt(j) - '0';
                  }
            }

            bfs();
            System.out.println(minCnt);
      }

      private static void bfs(){
            boolean[][][] visit = new boolean[N][M][K + 1];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};

            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(0, 0, 1, 0)); // (0, 0)에서 시작, 거리 1, 벽을 부순 횟수 0
            visit[0][0][0] = true;

            while (!queue.isEmpty()) {
                  Pair p = queue.poll();

                  // 도착지에 도달했을 때 최단 거리 갱신
                  if (p.x == N - 1 && p.y == M - 1) {
                        minCnt = p.dist;  // 최단 거리 갱신
                        return;  // 더 이상 탐색할 필요 없음
                  }

                  for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];

                        // 범위 체크
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                        // 벽을 부술 수 있는 경우
                        if (origin[nx][ny] == 1 && p.count < K && !visit[nx][ny][p.count + 1]) {
                              visit[nx][ny][p.count + 1] = true;
                              queue.add(new Pair(nx, ny, p.dist + 1, p.count + 1));
                        }

                        // 벽이 아니고 그냥 이동하는 경우
                        if (origin[nx][ny] == 0 && !visit[nx][ny][p.count]) {
                              visit[nx][ny][p.count] = true;
                              queue.add(new Pair(nx, ny, p.dist + 1, p.count));
                        }
                  }
            }
      }
}
