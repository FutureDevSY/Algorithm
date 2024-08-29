import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
      int next;
      int cost;

      public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
      }

      public int compareTo(Node o) {
            return this.cost - o.cost;
      }
}

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int start = Integer.parseInt(br.readLine());

            int[] dist = new int[V + 1];
            int INF = Integer.MAX_VALUE;
            Arrays.fill(dist, INF);

            List<List<Node>> graph = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                  graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                  st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
                  int w = Integer.parseInt(st.nextToken());

                  Node node = new Node(v, w);
                  graph.get(u).add(node);
            }

            dijkstra(start, dist, graph);

            for (int i = 1; i < dist.length; i++) {
                  System.out.println(dist[i] == INF ? "INF" : dist[i]);
            }
      }

      static void dijkstra(int start, int[] dist, List<List<Node>> graph) {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start, 0));
            dist[start] = 0;

            while (!queue.isEmpty()) {
                  Node node = queue.poll();
                  int next = node.next;
                  int cost = node.cost;

                  if (dist[next] < cost) {
                        continue;
                  }

                  for (int i = 0; i < graph.get(next).size(); i++) {
                        Node nextNode = graph.get(next).get(i);
                        int nextTarget = nextNode.next;
                        int nextCost = nextNode.cost + cost;

                        if(dist[nextTarget] > nextCost){
                              dist[nextTarget] = nextCost;
                              queue.add(new Node(nextTarget, nextCost));
                        }
                  }
            }
      }

}
