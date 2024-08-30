import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); //도시의 개수, 정점
            int M = Integer.parseInt(br.readLine()); //버스의 개수, 간선

            int[] dist = new int[N + 1];
            int INF = Integer.MAX_VALUE;
            Arrays.fill(dist, INF);

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                  graph.add(new ArrayList<>());
            }

            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int s = Integer.parseInt(st.nextToken());
                  int e = Integer.parseInt(st.nextToken());
                  int w = Integer.parseInt(st.nextToken());
                  graph.get(s).add(new Node(e, w));
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dijkstra(start, dist, graph);
            System.out.println(dist[end]);

      }

      static void dijkstra(int start, int[] dist, List<List<Node>> graph){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));
            dist[start] = 0;

            while (!pq.isEmpty()) {
                  Node curNode = pq.poll();
                  int next = curNode.next;
                  int cost = curNode.cost;

                  if(dist[next] != cost) continue;

                  for(int i=0; i<graph.get(next).size(); i++){
                        Node nextNode = graph.get(next).get(i);
                        int nextTarget = nextNode.next;
                        int nextCost = nextNode.cost + cost;

                        if (dist[nextTarget] > nextCost) {
                              dist[nextTarget] = nextCost;
                              pq.add(new Node(nextTarget, nextCost));
                        }
                  }
            }
      }

      static class Node implements Comparable<Node> {
            int next;
            int cost;

            public Node(int next, int cost) {
                  this.next = next;
                  this.cost = cost;
            }

            public int compareTo(Node node) {
                  return this.cost - node.cost;
            }
      }


}
