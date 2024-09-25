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
            public int compareTo(Node o){
                  if(this.end == o.end) return this.start - o.start;    //   이거안해서 틀렸었음...시작시간과 끝나는시간이 같은경우를 생각해보면...
                  return this.end - o.end;
            }
      }


      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Node> queue = new PriorityQueue<>();
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            int last = queue.poll().end;
            int cnt = 1;
            Node tmpNode;
            while(!queue.isEmpty()){
                  tmpNode = queue.poll();
                  if(tmpNode.start >= last){
                        cnt++;
                        last = tmpNode.end;
                  }
            }

            System.out.println(cnt);
      }

}
