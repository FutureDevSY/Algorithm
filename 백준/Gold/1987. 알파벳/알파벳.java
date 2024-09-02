import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, count;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;
    static int[] alpArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpArr = new int[26];
        map = new char[R][C];
        visit = new boolean[R][C];
        for(int i=0; i<R; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                map[i][j] = tmp[j];
            }
        }
        alpArr[map[0][0] - 'A'] = 1;
        visit[0][0] = true;    //방문체크
        dfs(0,0, 1);

        bw.write(Integer.toString(count));
        bw.close();
    }

    private static void dfs(int y, int x, int cnt){
        int ny = y;
        int nx = x;
        for(int i=0; i<4; i++){
            if(y + dy[i] < 0 || y + dy[i] >= R || x + dx[i] < 0 || x + dx[i] >= C || visit[y + dy[i]][x + dx[i]] || alpArr[map[y + dy[i]][x + dx[i]] - 'A'] == 1) continue;
            ny = y + dy[i];
            nx = x + dx[i];
            char tmpChr = map[ny][nx];
            alpArr[tmpChr - 'A'] = 1;
            visit[ny][nx] = true;
            dfs(ny, nx, cnt + 1);
            alpArr[tmpChr - 'A'] = 0;
            visit[ny][nx] = false;
        }
        count = Math.max(count, cnt);
    }
}
