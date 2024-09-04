import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AC_re {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());  //테케 수

            for (int t = 0; t < T; t++) {
                  String ac = br.readLine();
                  int arrSize = Integer.parseInt(br.readLine());
                  StringBuilder sb = new StringBuilder();
                  StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

                  ArrayDeque<Integer> deque = new ArrayDeque<>();
                  while(st.hasMoreTokens()) {
                        deque.add(Integer.parseInt(st.nextToken()));
                  }

                  int dir = 1;      //방향. 1이면 순방향, -1면 역방향으로
                  String result = "";
                  for (int i = 0; i < ac.length(); i++) {
                        if (ac.charAt(i) == 'R') {
                              dir = -dir;
                        } else if (ac.charAt(i) == 'D') {
                              if(deque.isEmpty()){
                                    result = "error";
                                    break;
                              }
                              if (dir == 1) {
                                    deque.removeFirst();
                              } else if (dir == -1) {
                                    deque.removeLast();
                              }
                        }
                  }

                  sb = new StringBuilder();

                  if (!result.equals("error")) {
                        sb.append("[");
                        if (dir == 1) {
                              if(!deque.isEmpty()) sb.append(deque.pollFirst());
                              while(!deque.isEmpty()) {
                                    sb.append(",");
                                    sb.append(deque.pollFirst());
                              }
                        } else if (dir == -1) {
                              if(!deque.isEmpty()) sb.append(deque.pollLast());
                              while(!deque.isEmpty()) {
                                    sb.append(",");
                                    sb.append(deque.pollLast());
                              }
                        }
                        sb.append("]");
                        result = sb.toString();
                  }

                  System.out.println(result);
            }
      }

}
