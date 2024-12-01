
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
      static int M, N;
      static int[][] box;
      static int unriped = 0;
      static int total = 0;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로칸수
            N = Integer.parseInt(st.nextToken());  //세로칸수

            box = new int[N][M];
            int[][] tomatoTmp = new int[N][M];
            int riped = 0;
            int tomatoes = 0;
            boolean flag = false;

            for (int j = 0; j < N; j++) {
                  st = new StringTokenizer(br.readLine());
                  for (int k = 0; k < M; k++) {
                        box[j][k] = Integer.parseInt(st.nextToken());
                        if(box[j][k] != -1) total++;
                        if(box[j][k] == 0) unriped++;
                        if(box[j][k] == 1) queue.add(new Tomato(j,k,0));
                  }
            }

            bfs();

      }

      static int[] moveN = {-1, 0, 1, 0};
      static int[] moveM = {0, 1, 0, -1};
      static Queue<Tomato> queue = new LinkedList<>();
      static int[][] isVisited = new int[N][M];
      static int ripedCnt = 0;
      static boolean flag = false;
      private static void bfs(){
            Tomato curToma = new Tomato(0,0,0);
            int nx, ny;
            int result = 0;

            outerloop:
            while (!queue.isEmpty()) {
                  curToma = queue.poll();

                  for (int i = 0; i < 4; i++) {
                        nx = curToma.x + moveN[i];
                        ny = curToma.y + moveM[i];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M || box[nx][ny] == 1 || box[nx][ny] == -1) continue;
                        box[nx][ny] = 1;
                        ripedCnt++;
                        flag = true;      //하나라도 새로 익게되는 경우가 있다면 전체 토마토가 이미 익어있는 상태는 아닐테닊나
                        queue.add(new Tomato(nx, ny, curToma.time + 1));
                        if(ripedCnt == unriped){
                              result = curToma.time + 1;
                              break outerloop;
                        }
                  }
            }

            if(ripedCnt < unriped || unriped == total) result = -1;  //모두 익지 못하는 상태
            else if(!flag) result = 0;   //모든 토마토가 이미 익어있는 상태

            System.out.println(result);
      }

      private static class Tomato {
            int x;
            int y;
            int time;


            Tomato( int x, int y, int time){
                  this.x = x;
                  this.y = y;
                  this.time = time;
            }
      }

}
