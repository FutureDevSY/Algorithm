import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {     // 백준 트리의 부모찾기 문제
    static int[] visited;
    static ArrayList<Integer>[] tree;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] parentNode;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());    //노드의 개수
        tree = (ArrayList<Integer>[]) new ArrayList[T + 1];    //제네릭 타입
        visited = new int[T + 1];
        parentNode = new int[T + 1];
        for (int i = 0; i < T + 1; i++) {
            tree[i] = new ArrayList<Integer>();     //초기화
        }
        for (int i = 0; i < T-1; i++) {     //트리니까 간선은 노드 개수 -1
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        visited[1] = 1; //1만 따로 방문체크해줌
        bfs(1);
        for (int i = 2; i <= T; i++) {
            bw.write(Integer.toString(parentNode[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int nd) throws IOException{
        for (int n : tree[nd]) {
            if (visited[n] == 0) {
                parentNode[n] = nd;
                queue.add(n);
                visited[n] = visited[nd] + 1;
            }
        }
        if (!queue.isEmpty()) {
            bfs(queue.remove());
        }

    }
}
