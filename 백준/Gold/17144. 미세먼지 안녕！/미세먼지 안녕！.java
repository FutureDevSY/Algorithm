import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      static int R, C, T;
      static int[][] room, roomTmp;
      static int refresh;     //공청기의 위쪽 x칸좌표

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            room = new int[R][C];
            roomTmp = new int[R][C];
            refresh = -1;
            int tmp = 0;
            for (int i = 0; i < R; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < C; j++) {
                        tmp = Integer.parseInt(st.nextToken());
                        if(tmp == -1 && refresh == -1) refresh = i;
                        room[i][j] = tmp;
                  }
            }

            for (int t = 0; t < T; t++) {
                  spread();
                  circulate();
            }

//            for(int[] arr : room){
//                  System.out.println(Arrays.toString(arr));
//            }

            System.out.println(countSum());


      }

      static int[] dr = {-1, 0, 1, 0};
      static int[] dc = {0, 1, 0, -1};
      private static void spread(){
            roomTmp = new int[R][C];
            int nr = 0;
            int nc = 0;
            for (int i = 0; i < R; i++) {
                  for (int j = 0; j < C; j++) {
                        if(room[i][j] != 0 && room[i][j] != -1){
                              for(int k=0; k<4; k++){
                                    nr = i + dr[k];
                                    nc = j + dc[k];
                                    if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                                          if((nr == refresh || nr == refresh + 1) && nc == 0) continue;
                                          roomTmp[nr][nc] += room[i][j] / 5;
                                          roomTmp[i][j] -= room[i][j] / 5;
                                    }
                              }
                        }
                  }
            }

            for (int i = 0; i < R; i++) {
                  for (int j = 0; j < C; j++) {
                        if(room[i][j] == -1) continue;
                        room[i][j] = room[i][j] + roomTmp[i][j];
                  }
            }
      }

      private static void circulate(){
            //위쪽 반시계방향 회전
            for (int i = refresh - 2; i >= 0; i--) {
                  room[i + 1][0] = room[i][0];
            }
            for (int i = 1; i < C; i++) {
                  room[0][i - 1] = room[0][i];
            }
            for (int i = 1; i <= refresh; i++) {
                  room[i - 1][C - 1] = room[i][C - 1];
            }
            for (int i = C - 2; i >= 1; i--) {
                  room[refresh][i + 1] = room[refresh][i];
            }
            room[refresh][1] = 0;

            //아래쪽 시계방향 회전
            for (int i = refresh + 3; i < R; i++) {
                  room[i - 1][0] = room[i][0];
            }
            for (int i = 1; i < C; i++) {
                  room[R - 1][i - 1] = room[R - 1][i];
            }
            for (int i = R - 2; i >= refresh + 1; i--) {
                  room[i + 1][C - 1] = room[i][C - 1];
            }
            for (int i = C - 2; i >= 1; i--) {
                  room[refresh + 1][i + 1] = room[refresh + 1][i];
            }
            room[refresh + 1][1] = 0;
      }

      private static int countSum(){
            int sum = 0;
            for (int i = 0; i < R; i++) {
                  for (int j = 0; j < C; j++) {
                        if(room[i][j] == -1) continue;
                        sum += room[i][j];
                  }
            }
            return sum;
      }

}
