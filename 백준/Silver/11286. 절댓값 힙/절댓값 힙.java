import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

      static class Node implements Comparable<Node>{
            long value;

            public Node(long value){
                  this.value = value;
            }

            @Override
            public int compareTo(Node o) {
                  if(Math.abs(this.value) == Math.abs(o.value)){
                        return Long.compare(this.value, o.value);
                  }else return Long.compare(Math.abs(this.value), Math.abs(o.value));
            }
      }

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            long tmp;
            PriorityQueue<Node> queue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                  tmp = Integer.parseInt(br.readLine());
                  if (tmp == 0) {
                        if(queue.isEmpty()){
                              bw.write("0" + '\n');
                        }else{
                              bw.write(Long.toString(queue.poll().value) + '\n');
                        }
                  }else{
                        queue.add(new Node(tmp));
                  }
            }

            bw.close();
      }

}
