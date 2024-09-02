import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] students, isCycle;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int n;  //학생수

        for(int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            students = new int[n+1];
            isCycle = new int[n+1];
            visited = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=n; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=n; i++){
                if(isCycle[i] == 0){    //팀 결성 성공했는지 실패했는지 아직 모르는 경우가 0
                    dfs(i);
                }
            }
            int count = 0;
            for(int i=1; i<=n; i++){
                if(isCycle[i] == 1) count++;
            }
            bw.write(Integer.toString(count));
            bw.newLine();
        }
        bw.flush();
    }
    static int end;
    private static int dfs(int nd) {
        if(visited[nd]){    //방문했던 노드라면 여기서 사이클이 만들어짐
            if(isCycle[nd] != 0) return 1;
            else{
                end = nd;
                return 2;
            }
        }
        visited[nd] = true;
        int result = dfs(students[nd]);
        isCycle[nd] = result;   //2가 반환되었다면 사이클 내에 있음, 1이라면 사이클 외

        if(end == nd || result == 1){   //첫 시작점 노드로 돌아왔다면 이때부터는 사이클 바깥
            return 1;
        }else {
            return 2;
        }
    }


}
