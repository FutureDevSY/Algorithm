import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

      static class Node implements Comparable<Node>{
            int dest;
            int cost;

            Node(int d, int c){
                dest = d;
                cost = c;
            }

            @Override
            public int compareTo(Node o){
                  return this.cost - o.cost;
            }
      }

      static int INF = 200000000;
      static ArrayList<Node>[] adjList;
      static int[] cost;
      static boolean[] visited;
      static int N, E;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //점점 개수
            E = Integer.parseInt(st.nextToken());  //간선 개수

            adjList = new ArrayList[N + 1];
            cost = new int[N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < adjList.length; i++) {
                  adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                  st = new StringTokenizer(br.readLine());
                  int a = Integer.parseInt(st.nextToken());
                  int b = Integer.parseInt(st.nextToken());
                  int c = Integer.parseInt(st.nextToken());

                  adjList[a].add(new Node(b, c));
                  adjList[b].add(new Node(a, c));
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int ans1 = 0;
            ans1 += dijkstra(1, v1);
            ans1 += dijkstra(v1, v2);
            ans1 += dijkstra(v2, N);

            int ans2 = 0;
            ans2 += dijkstra(1, v2);
            ans2 += dijkstra(v2, v1);
            ans2 += dijkstra(v1, N);

            int result = 0;
            if(ans1 >= INF && ans2 >= INF) result = -1;
            else result = Math.min(ans1, ans2);

            System.out.println(result);

      }

      static int dijkstra(int start, int end){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Arrays.fill(cost, INF);
            Arrays.fill(visited, false);  //다익스트라 호출시마다 초기화 꼭
            cost[start] = 0;
            pq.add(new Node(start, 0));

            while(!pq.isEmpty()){
                  Node curNode = pq.poll();
                  if(visited[curNode.dest]) continue;
                  visited[curNode.dest] = true;

                  for (Node next : adjList[curNode.dest]) {
                        if(cost[next.dest] > next.cost + curNode.cost){
                              cost[next.dest] = next.cost + curNode.cost;
                              pq.add(new Node(next.dest, cost[next.dest]));
                        }
                  }
            }
            return cost[end];

      }

}
