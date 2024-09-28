import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String[] strArr = new String[C];
            String tmpStr;
            for (int i = 0; i < R; i++) {
                  tmpStr = br.readLine();
                  for (int j = 0; j < C; j++) {
                        if(strArr[j] == null ) strArr[j] = Character.toString(tmpStr.charAt(j));
                        else strArr[j] += tmpStr.charAt(j);
                  }
            }

            int idx = 1;
            HashSet<String> set = new HashSet<>();
            for(int i=0; i < R - 1; i++){
                  set = new HashSet<>();
                  for(int j=0; j<C; j++){
                        set.add(strArr[j].substring(idx));
                  }
                  if(set.size() != C) break;    //중복되는 문자열이 있다고 판단
                  else idx++;
            }

            bw.write(Integer.toString(idx - 1));
            bw.flush();
      }

}
