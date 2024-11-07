import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static class Pair{
            int x;
            int y;

            public Pair(int x, int y){
                  this.x = x;
                  this.y = y;
            }
      }

      static int N, M, wallCnt, virusCnt, virusMin;
      static int[][] map;
      static ArrayList<Pair> virusLoc;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            wallCnt = 0;
            virusCnt = 0;
            virusMin = Integer.MAX_VALUE;
            virusLoc = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < M; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                        if(map[i][j] == 1) wallCnt++;
                        else if(map[i][j] == 2) {
                              virusCnt++;
                              virusLoc.add(new Pair(i, j));
                        }
                  }
            }

            dfs(map, 0);
            System.out.println((N * M) - virusMin - (wallCnt + 3));

      }

      public static void dfs(int[][] map, int cnt){
            int virus = 0;
            Pair tmpPair;
            if(cnt >= 3){
                  int[][] copyMap = new int[N][M];
                  copyMap = mapCopy(map);
                  //bfs로 바이러스 퍼짐 확인
                  for (int i = 0; i < virusLoc.size(); i++) {
                        tmpPair = virusLoc.get(i);
                        bfs(copyMap, tmpPair.x, tmpPair.y);
                  }
                  //바이러스 개수 세기

                  virusMin = Math.min(virusMin, cntVirus(copyMap));
                  return;
            }
            int tmpCnt = 0;
            for (int i = 0; i < N; i++) {
                  for (int j = 0; j < M; j++) {
                        if(map[i][j] == 0){
                              map[i][j] = 1;
                              dfs(map, cnt + 1);
                              map[i][j] = 0;
                        }
                  }
            }

      }

      static int[] dirX = {-1, 0, 1, 0};
      static int[] dirY = {0, 1, 0, -1};

      public static int[][] bfs(int[][] map, int x, int y){
            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(x, y));
            int virus = 1;

            Pair cur;
            int nx, ny;

            while(!q.isEmpty()){
                  cur = q.poll();
                  for (int i = 0; i < 4; i++) {
                       nx = cur.x + dirX[i];
                       ny = cur.y + dirY[i];

                       if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                       if(map[nx][ny] == 0){
                             virus++;
                             map[nx][ny] = 2;
                             q.add(new Pair(nx, ny));
                       }
                  }
            }
            return map;
      }

      public static int[][] mapCopy(int[][] map){
            int[][] copyMap = new int[N][M];
            int idx = 0;
            for (int[] m : map) {
                  copyMap[idx++] = Arrays.copyOf(m, m.length);
            }
            return copyMap;
      }

      public static int cntVirus(int[][] map){
            int cnt = 0;
            for(int i=0; i<N; i++){
                  for (int j = 0; j < M; j++) {
                        if(map[i][j] == 2) cnt++;
                  }
            }
            return cnt;
      }



}
