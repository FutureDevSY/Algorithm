import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

      static String start;
      static String target;
      static int result = 0;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            start = br.readLine();       //얘를
            target = br.readLine();      //얘로 만들수있는가

            System.out.println(dfs(target));

      }

      static StringBuilder sb;
      private static int dfs(String str){
            if(str.length() == start.length()){
                  if(str.equals(start)) {
                        result = 1;
                        return 1;
                  }
                  else return 0;
            }
            int res;
            String tmpStr;
            if(str.charAt(str.length() - 1) == 'A'){
                  tmpStr = str.substring(0, str.length() - 1);
                  res = dfs(tmpStr);
                  if(res == 1) return 1;
            }
            if(str.charAt(0) == 'B'){
                  sb = new StringBuilder();
                  for (int i = str.length() - 1; i >= 0; i--) {
                        sb.append(str.charAt(i));
                  }
                  tmpStr = sb.toString();
                  tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
                  res = dfs(tmpStr);
                  if(res == 1) return 1;
            }

            return 0;
      }

}
