import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] edges;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M; //과목 수, 선수 조건 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        edges = new int[N + 1]; //진입차수
        int A, B;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            edges[B]++;
        }

        time = new int[N + 1]; //과목별 이수하려면 걸리는 최소학기
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < time.length; i++) {
            sb.append(time[i]);
            sb.append(" ");
        }
        System.out.println(sb);

    }

    static class Node{
        int num;
        int minTime;

        Node(int num, int minTime){
            this.num = num;
            this.minTime = minTime;
        }
    }

    private static void bfs(){
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 1; i < edges.length; i++) {
            if(edges[i] == 0){
                queue.add(new Node(i, 1));
                time[i] = 1;
            }
        }

        Node curNode;
        int nextNodeNum;

        while(!queue.isEmpty()){
            curNode = queue.poll();
            for (int i = 0; i < graph[curNode.num].size(); i++) {
                nextNodeNum = graph[curNode.num].get(i);
                edges[nextNodeNum]--;
                if(edges[nextNodeNum] == 0) {
                    queue.add(new Node(nextNodeNum, curNode.minTime + 1));
                    time[nextNodeNum] = curNode.minTime + 1;
                }
            }
        }
    }
}
