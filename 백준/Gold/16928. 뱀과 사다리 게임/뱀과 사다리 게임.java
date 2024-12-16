import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static class Node{
            int cur;
            int count;

            public Node(int cur, int count){
                  this.cur = cur;
                  this.count = count;
            }
      }

      static int N, M;  //사다리 , 뱀
      static HashMap<Integer, Integer> map;
      static int[] minMove;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            minMove = new int[101];
            map = new HashMap<>();
            int start, end;
            for (int i = 0; i < N + M; i++) {
                  st = new StringTokenizer(br.readLine());
                  start = Integer.parseInt(st.nextToken());
                  end = Integer.parseInt(st.nextToken());
                  map.put(start, end);
            }

            bfs();
            System.out.println(minMove[100]);


      }

      private static void bfs(){
            Queue<Node> queue = new ArrayDeque();
            boolean[] visited = new boolean[101];
            queue.add(new Node(1, 0));
            visited[1] = true;

            Node curNode;
            int nextNum;
            while(!queue.isEmpty()){
                  curNode = queue.poll();
                  for (int i = 1; i <= 6; i++) {
                        nextNum = curNode.cur + i;
                        if(nextNum > 100 || visited[nextNum]) continue;

                        if(map.containsKey(nextNum)){
                              minMove[map.get(nextNum)] = curNode.count + 1;
                              queue.add(new Node(map.get(nextNum), curNode.count + 1));
                              visited[map.get(nextNum)] = true;
                        }else{
                              minMove[nextNum] = curNode.count + 1; //?
                              queue.add(new Node(nextNum, curNode.count + 1));
                        }
                        visited[nextNum] = true;
                  }
            }
      }

}
