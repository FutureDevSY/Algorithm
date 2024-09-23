import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

      static class Node implements Comparable<Node>{
            int start;
            int end;

            public Node(int start, int end){
                  this.start = start;
                  this.end = end;
            }


            @Override
            public int compareTo(Node o) {
                  if(o.start == this.start) return this.end - o.end;
                  return this.start - o.start;
            }
      }

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            PriorityQueue<Node> queue = new PriorityQueue<>(); //가장 빠른 시작시간 순
            PriorityQueue<Integer> ends = new PriorityQueue<>(); //가장 빠른 종료시간 순

            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            ends.add(queue.poll().end);
            int earliestEnd = 0;
            Node curNode;
            while(!queue.isEmpty()){
                  earliestEnd = ends.peek();
                  curNode = queue.peek();
                  if(curNode.start >= earliestEnd){
                        ends.poll();
                        ends.add(queue.poll().end);
                  }else{
                        ends.add(queue.poll().end);
                  }
            }

            System.out.println(ends.size());
      }

}
