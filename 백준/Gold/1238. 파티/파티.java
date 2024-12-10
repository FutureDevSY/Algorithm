import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

      static class Node implements Comparable<Node>{
            int num;
            int weight;

            Node(int num, int weight){
                  this.num = num;
                  this.weight = weight;
            }

            @Override
            public int compareTo(Node node){
                  return this.weight - node.weight;
            }
      }

      static int INF = 987654321;
      static ArrayList<Node>[] arrList, revArrList;
      static int N, M, X;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //마을 수
            M = Integer.parseInt(st.nextToken()); //단방향 도로 수
            X = Integer.parseInt(st.nextToken()); //파티장소

            arrList = new ArrayList[N + 1];
            revArrList = new ArrayList[N + 1];
            for (int i = 0; i < arrList.length; i++) {
                  arrList[i] = new ArrayList<>();
                  revArrList[i] = new ArrayList<>();
            }

            int start, end, weight;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  start = Integer.parseInt(st.nextToken());
                  end = Integer.parseInt(st.nextToken());
                  weight = Integer.parseInt(st.nextToken());

                  arrList[start].add(new Node(end, weight));
                  revArrList[end].add(new Node(start, weight));
            }

            int[] dist1 = dijkstra(arrList);
            int[] dist2 = dijkstra(revArrList);
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                  ans = Math.max(dist1[i] + dist2[i], ans);
            }

            bw.write(Integer.toString(ans));
            bw.flush();
            bw.close();
      }

      public static int[] dijkstra(ArrayList<Node>[] list){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(X, 0));
            boolean[] visited = new boolean[N + 1];
            int[] dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[X] = 0;

            while (!queue.isEmpty()) {
                  Node curNode = queue.poll();
                  int curNum = curNode.num;

                  if(!visited[curNum]){
                        visited[curNum] = true;
                        for (Node node : list[curNum]) {
                              if(!visited[node.num] && dist[node.num] > dist[curNum] + node.weight){
                                    dist[node.num] = dist[curNum] + node.weight;
                                    queue.add(new Node(node.num, dist[node.num]));
                              }
                        }
                  }
            }
            return dist;
      }

}
