import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st;
            while (T-- > 0) {
                  int n = Integer.parseInt(br.readLine());
                  TreeMap<Integer, Integer> tm = new TreeMap<>();
                  for (int i = 0; i < n; i++) {
                        st = new StringTokenizer(br.readLine());
                        char order = st.nextToken().charAt(0);
                        int val = Integer.parseInt(st.nextToken());

                        if(order == 'I'){
                              tm.put(val, tm.getOrDefault(val, 0) + 1);
                        }else if(!tm.isEmpty()){
                              if(val == 1){
                                    //최댓값 삭제
                                    int num = tm.lastKey();
                                    if(tm.get(num) == 1){
                                          tm.remove(num);
                                    }else{
                                          tm.put(num, tm.get(num) - 1);
                                    }
                              }else{
                                    //최솟값 삭제
                                    int num = tm.firstKey();
                                    if(tm.get(num) == 1){
                                          tm.remove(num);
                                    }else{
                                          tm.put(num, tm.get(num) - 1);
                                    }
                              }
                        }
                  }
                  if(!tm.isEmpty()){
                        bw.write(Integer.toString(tm.lastKey()) + " " + Integer.toString(tm.firstKey()));
                  }else{
                        bw.write("EMPTY");
                  }
                  bw.write('\n');

            }
            bw.flush();
            bw.close();

      }
}
