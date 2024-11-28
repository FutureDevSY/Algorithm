import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            HashSet<String> set = new HashSet<>();

            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                  set.add(br.readLine());
            }
            String tmpStr;
            ArrayList<String> list = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                  tmpStr = br.readLine();
                  if(set.contains(tmpStr)){
                        cnt++;
                        list.add(tmpStr);
                  }
            }
            bw.write(Integer.toString(cnt) + '\n');
            // 사전순으로 출력
            Collections.sort(list);
            for (String str : list) {
                  bw.write(str + '\n');
            }
            bw.close();
      }

}
