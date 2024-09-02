import java.io.*;
import java.util.StringTokenizer;

public class Main { //외판원순회2
    static int[][] map;
    static boolean[] visited;
    static int N ,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());    //정점개수
        map = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N; i++){
            visited[i] = true;
            dfs(i,1,i,0);
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }
    private static void dfs(int start, int depth, int cur, int sum){
        if(depth >= N){ //모든 정점 다 선택
            if(map[cur][start] != 0) {
                sum += map[cur][start];
                min = Math.min(min, sum);  //마지막에 선택한 정점에서 출발지점으로 돌아가는 경로가 있다면 비용갱신
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i] && map[cur][i] != 0){    //아직 방문안한 정점이면서 i번 정점으로 가는 경로가 존재
                visited[i] = true;
                dfs(start, depth + 1, i, sum + map[cur][i]);
                visited[i] = false;
            }
        }
    }

}
