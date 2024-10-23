import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N, M; //포켓몬 개수, 문제 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            HashMap<String, String> map = new HashMap<>();
            String tmp;
            for (int i = 1; i <= N; i++) {
                  tmp = br.readLine();
                  map.put(tmp, Integer.toString(i));
                  map.put(Integer.toString(i), tmp);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                  tmp = br.readLine();
                  sb.append(map.get(tmp)).append('\n');

            }
            bw.write(sb.toString());
            bw.close();
      }

}
