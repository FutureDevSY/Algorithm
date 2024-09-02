import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {   //백준 11724번 연결 요소 문제
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count = 0;   //방문한 횟수
    static boolean[] checked;
    static int connect = 0; //연결 요소의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //정점의 개수
        int M = Integer.parseInt(st.nextToken());   //간선의 개수

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {  //N+1크기로 해줘야함
            graph.add(new ArrayList<>());  //arraylist 초기화, 초기화하는법 그만까먹어!!
        }
        checked = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        while (count != N) {    //모든 정점을 다 방문할떄까지 진행한다
            for (int i = 1; i <= N; i++) {
                if (!checked[i]) {
                    dfs(i);
                    connect++;  //dfs가 수행되는 횟수만큼이 연결요소의 개수가 될 거라 생각함
                }
            }
        }

        bw.write(Integer.toString(connect));
        bw.flush();
        bw.close();
    }

    static void dfs(int n) {
        checked[n] = true;
        count++;
        for (int i : graph.get(n)) {
            if (!checked[i]) {  //방문 안한 노드라면
                dfs(i);
            }
        }

    }
}
