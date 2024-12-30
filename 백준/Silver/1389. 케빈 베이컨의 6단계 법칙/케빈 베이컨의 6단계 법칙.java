import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] li = new ArrayList[N + 1];
            for(int i=0; i<li.length; i++){
                  li[i] = new ArrayList<>();
            }
            int a, b;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());
                  li[a].add(b);
                  li[b].add(a);
            }

            int[] cntArr = new int[N + 1];
            int min = Integer.MAX_VALUE;
            int minKB = -1;
            for(int i=1; i<=N; i++){
                  cntArr[i] = bfs(li, i, N);
                  if(cntArr[i] == min && minKB > i){
                        minKB = i;
                  }
                  if(cntArr[i] < min) {
                        minKB = i;
                        min = cntArr[i];
                  }
            }
            System.out.println(minKB);
      }
      static class Node{
            int num;
            int dist;

            public Node(int n, int d){
                  num = n;
                  dist = d;
            }
      }
      static int bfs(ArrayList<Integer>[] list, int start, int N){
            Queue<Node> queue = new ArrayDeque();
            queue.add(new Node(start, 0));
            boolean[] visited = new boolean[N + 1];
            visited[start] = true;

            int sum = 0;
            Node curNode;
            int next;
            while(!queue.isEmpty()){
                  curNode = queue.poll();
                  for(int i=0; i<list[curNode.num].size(); i++){
                        next = list[curNode.num].get(i);
                        if(!visited[next]){
                              queue.add(new Node(list[curNode.num].get(i), curNode.dist + 1));
                              sum += curNode.dist + 1;
                              visited[next] = true;
                        }

                  }
            }
            return sum;
      }
}
