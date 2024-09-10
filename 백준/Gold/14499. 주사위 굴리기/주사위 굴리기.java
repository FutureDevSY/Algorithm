import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //주사위 굴리기

      static int N, M, K;
      static int[][] map;
      static int[] order;
      static int[] diceNums;
      static int diceX, diceY;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                  N = Integer.parseInt(st.nextToken());     //맵 height
                  M = Integer.parseInt(st.nextToken());     //맵 width
                  diceX = Integer.parseInt(st.nextToken());
                  diceY = Integer.parseInt(st.nextToken());
                  K = Integer.parseInt(st.nextToken());
            }
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < M; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            st = new StringTokenizer(br.readLine());
            order = new int[K];
            for (int i = 0; i < K; i++) {
                  order[i] = Integer.parseInt(st.nextToken());
            }

            int k = 0;
            diceNums = new int[6];

            while (k < K) {
                  moveDice(order[k++]);
            }


      }
      static void moveDice(int dir){    //이동방향, 현재위치x,y
            int[] tmpNums = Arrays.copyOf(diceNums, diceNums.length);

            if (dir == 1) {
                  if(diceY + 1 >= M) return;
                  diceY++;
                  tmpNums[1] = diceNums[2];
                  tmpNums[5] = diceNums[3];
                  tmpNums[3] = diceNums[1];
                  tmpNums[2] = diceNums[5];
            }else if(dir == 2){
                  if(diceY - 1 < 0) return;
                  diceY--;
                  tmpNums[3] = diceNums[5];
                  tmpNums[2] = diceNums[1];
                  tmpNums[5] = diceNums[2];
                  tmpNums[1] = diceNums[3];
            }else if(dir == 3){
                  if(diceX - 1 < 0) return;
                  diceX--;
                  tmpNums[0] = diceNums[1];
                  tmpNums[1] = diceNums[4];
                  tmpNums[4] = diceNums[5];
                  tmpNums[5] = diceNums[0];
            } else if (dir == 4) {
                  if(diceX + 1 >= N) return;
                  diceX++;
                  tmpNums[1] = diceNums[0];
                  tmpNums[4] = diceNums[1];
                  tmpNums[5] = diceNums[4];
                  tmpNums[0] = diceNums[5];


            }

            diceNums = Arrays.copyOf(tmpNums, tmpNums.length);
            if (map[diceX][diceY] == 0) {
                  map[diceX][diceY] = diceNums[5];
            }else{
                  diceNums[5] = map[diceX][diceY];
                  map[diceX][diceY] = 0;
            }

            System.out.println(diceNums[1]);

      }

}
