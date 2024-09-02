import java.io.*;
import java.util.*;

public class Main {    //백준 1260번 DFS BFS문제
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());;
        int V = Integer.parseInt(st.nextToken());;    //정점개수,간선개수,탐색 시작점
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N+1; i++) {     //크기 신경써라
            graph.add(new ArrayList<>());   //그래프 초기화
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);    //양방향은 꼭 반대로도!!
        }
        checked = new boolean[N + 1];   //0부터ㄴㄴ1부터 N까지

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i)); //왜 여기서 INdexOutOFBoundsException이 났을까
        }

        dfs(V);
        System.out.println();
        checked = new boolean[N + 1];   //배열 초기화해줌
        bfs(V);

    }
    static void dfs(int x) {
        checked[x] = true;
        System.out.print(x + " ");
        for (int i : graph.get(x)) {
            if (!checked[i]) {   //방문안한 정점이면 dfs수행
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        checked[x] = true;
        while (!q.isEmpty()) {  //큐가 빌때까지 반복
            int n = q.remove();
            System.out.print(n + " ");
            for (int i : graph.get(n)) {
                if (!checked[i]) {
                    checked[i] = true;
                    q.add(i);
                }

            }
        }
    }
}
