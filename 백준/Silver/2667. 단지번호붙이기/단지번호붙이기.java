import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static List<Integer> li = new ArrayList<>();	//단지 수 저장
    static int[][] map;
    static boolean[][] visited;
    static int N, sum, count;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        sum = 1;    //for문에서 애초에 1인 애를 찾아서 dfs돌리기때문에 1로 시작해야함
        count = 0;

        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;   //일단 시작점부터 방문체크 해줘야함
                    dfs(i, j);
                    li.add(sum);
                    sum = 1;
                }
            }
        }

        Collections.sort(li);

        System.out.println(count);
        for(int i : li) {
            System.out.println(i);
        }

    }

    public static void dfs(int x, int y) {
        for (int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum++;
                    dfs(nx, ny);
                }
            }
        }
    }
}