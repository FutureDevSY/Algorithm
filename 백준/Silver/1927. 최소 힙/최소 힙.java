import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            long todo = 0;
            for(int i=0; i<N; i++){
                  todo = Integer.parseInt(br.readLine());
                  if(todo == 0){
                        if(pq.isEmpty()) bw.write("0" + '\n');
                        else bw.write(Long.toString(pq.poll() ) + '\n');
                  }else{
                        pq.add(todo);
                  }
            }

            bw.flush();
            bw.close();
      }

}
