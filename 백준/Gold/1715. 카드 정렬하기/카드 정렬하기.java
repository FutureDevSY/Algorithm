import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                  pq.add((long)Integer.parseInt(br.readLine()));
            }


            if(N == 1) System.out.println(0);
            else if(N == 2) System.out.println(pq.poll() + pq.poll());
            else{
                  long sum = 0;
                  long tmp = 0;
                  while(pq.size() > 1){
                        tmp = pq.poll() + pq.poll();
                        pq.add(tmp);
                        sum += tmp;
                  }
                  System.out.println(sum);
//                  System.out.println(pq.poll());
            }
      }

}
