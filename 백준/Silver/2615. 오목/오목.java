import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      static int[][] board;
      static boolean[][] visited;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            board = new int[19][19];
            visited = new boolean[19][19];
            boolean result = false;

            StringTokenizer st;
            for(int i=0; i<19; i++){
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < 19; j++) {
                        board[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            out : for (int i = 0; i < 19; i++) {
                  for (int j = 0; j < 19; j++) {
//                        if(board[j][i] != 0 && !visited[j][i]){
                        if(board[j][i] != 0){
                              result = check(j, i, board[j][i]);
//                              visited[j][i] = true;
                              if(result){
                                    System.out.println(board[j][i]);
                                    System.out.println((j + 1) + " " + (i + 1));
                                    break out;
                              }
                        }
                  }
            }
            if(!result) System.out.println(0);
      }

      //북동, 동, 동남, 남
      static int[] dx = {1, 1, 1, 0};
      static int[] dy = {-1, 0, 1, 1};
      static int[] ux = {-1, -1, -1, 0};
      static int[] uy = {1, 0, -1, -1};
      static boolean check(int x, int y, int team){
            int nx, ny, count;
            for (int i = 0; i < 4; i++) {
                  count = 1;
                  nx = x;
                  ny = y;
                  while(true){
                        nx = nx + dx[i];
                        ny = ny + dy[i];
                        if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break;
                        if(board[nx][ny] == 0) break;
                        if(board[nx][ny] != team) break;
                        count++;
                        visited[nx][ny] = true;
                  }
                  nx = x;
                  ny = y;
                  while(true){
                        nx = nx + ux[i];
                        ny = ny + uy[i];
                        if(nx < 0 || nx >= 19 || ny < 0 || ny >= 19) break;
                        if(board[nx][ny] == 0) break;
                        if(board[nx][ny] != team) break;
                        count++;
                        visited[nx][ny] = true;
                  }
                  if(count == 5) return true;
            }
            return false;
      }

}
