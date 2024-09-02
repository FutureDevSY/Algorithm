import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, M;
    static List<List<Integer>> nodeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //하이퍼튜브 자체를 별개의 하나의 노드로 두는게 핵심이었던 문제..
        //이동시 하이퍼튜브 노드로 갈때는 비용 0, 일반 노드로 갈때는 1을 적용
        //다만 이렇게 했을때 어떻게 일반적인 BFS가 적용될수 있는건지는 아직 의문이고 찜찜하다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    //역의 개수
        K = Integer.parseInt(st.nextToken());    //하이퍼튜브가 서로 연결하는 역의 개수
        M = Integer.parseInt(st.nextToken());    //하이퍼튜브 개수
        int tmp;

        for(int i=0; i<N+M+1; i++){
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                tmp = Integer.parseInt(st.nextToken());
                //하이퍼튜브 개수(N)만큼의 노드 다음부터 하이퍼튜브 노드를 생성
                nodeList.get(tmp).add(N + 1 + i);
                nodeList.get(N + 1 + i).add(tmp);
            }
        }
        
        if(N == 1) System.out.println(1);   //걍 따로 예외처리해줌..
        else System.out.println(bfs());
    }

    public static int bfs() {
        boolean[] visited = new boolean[N + M + 1];
        int[] cost = new int[N + M + 1];
        cost[1] = 1;    //첫번째(0번째)노드 비용 1에서 시작
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);    //1번 노드부터 시작
        visited[1] = true;

        int tmp = 0;
        int nodeNum = 0;
        int minCnt = 0;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            for (int i = 0; i < nodeList.get(tmp).size(); i++) {
                nodeNum = nodeList.get(tmp).get(i);
                if (visited[nodeNum]) continue;

                queue.add(nodeNum);
                visited[nodeNum] = true;

                if (nodeNum - N <= 0) {    //일반 노드를 거치게 된다면 비용 1 카운트,
                    cost[nodeNum] = cost[tmp] + 1;
                } else {  //하이퍼튜브 노드라면 카운트 증가 x, 이전에 거쳐온 노드 비용 값 그대로 간다
                    cost[nodeNum] = cost[tmp];
                }
                if (nodeNum == N) {
                    return cost[nodeNum];  //N번째 노드까지의 최소거리 구했다면 리턴
                }
            }


        }
        return -1;  //갈수없는경우
    }

}

