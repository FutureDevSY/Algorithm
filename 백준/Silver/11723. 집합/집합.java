import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            HashSet<Integer> set = new HashSet<>();


            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;
            String order;
            int val = 0;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  order = st.nextToken();
                  if(st.hasMoreTokens()){
                        val = Integer.parseInt(st.nextToken());
                  }

                  if(order.equals("add")){
                        set.add(val);
                  }else if(order.equals("remove")){
                        set.remove(val);
                  } else if (order.equals("check")) {
                        if(set.contains(val)) sb.append(1).append('\n');
                        else sb.append(0).append('\n');
                  } else if (order.equals("toggle")) {
                        if(set.contains(val)) set.remove(val);
                        else set.add(val);
                  } else if (order.equals("all")) {
                        for (int j = 1; j <= 20; j++) {
                              set.add(j);
                        }
                  } else if (order.equals("empty")) {
                        set.clear();
                  }
            }
            bw.write(sb.toString());
            bw.close();
      }
}
