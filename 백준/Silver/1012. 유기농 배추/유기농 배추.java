import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;   //배추심는 땅
    static boolean[][] visited; //방문체크
    static int[] dirY = {-1, 0, 1, 0}; //상 우 하 좌 순서
    static int[] dirX = {0, 1, 0, -1};
    static int width; static int height;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());    //테스트케이스 수
        int num;    //배추 개수
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            board = new int[height][width];
            visited = new boolean[height][width];
            num = Integer.parseInt(st.nextToken());
            count = 0;

            int x; int y;
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());   //배추심은곳 x좌표(행,row)
                y = Integer.parseInt(st.nextToken());   //배추심은곳 y좌표(열, col)
                board[y][x] = 1;
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) { //배추가 있는 지역이면 dfs를 수행한다
                        dfs(j, i);
                        count++;
                    }
                }
            }

            bw.write(Integer.toString(count));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int tmpx = x + dirX[i];
            int tmpy = y + dirY[i];
            if (tmpx >= 0 && tmpx < width && tmpy >= 0 && tmpy < height && !visited[tmpy][tmpx] && board[tmpy][tmpx] == 1) {
                visited[tmpy][tmpx] = true;
                dfs(tmpx, tmpy);
            }
        }
    }
}
