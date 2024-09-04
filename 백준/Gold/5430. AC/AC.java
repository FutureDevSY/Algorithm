import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());  //테케 수

            for (int t = 0; t < T; t++) {
                  String ac = br.readLine();
                  int arrSize = Integer.parseInt(br.readLine());
                  String str = br.readLine();
                  StringBuilder sb = new StringBuilder();
                  int[] intArr = new int[arrSize];
                  if(str != "[]"){
                        String subStr = str.substring(1, str.length() - 1);

                        StringTokenizer st = new StringTokenizer(subStr, ",");
                        int tmp=0;
                        while(st.hasMoreTokens()) {
                              intArr[tmp++] = Integer.parseInt(st.nextToken());
                        }
                  }

                  int pointerF = 0;  //가리킬 인덱스
                  int pointerB = intArr.length - 1;
                  int dir = 1;      //방향. 1이면 순방향, -1면 역방향으로
                  String result = "[]";

                  for (int i = 0; i < ac.length(); i++) {
                        if (ac.charAt(i) == 'R') {
                              dir = -dir;
                        } else if (ac.charAt(i) == 'D') {
                              if (pointerF > pointerB) {
                                    result = "error";
                                    break;
                              }
                              if (dir == 1) {
                                    pointerF++;
                              } else if (dir == -1) {
                                    pointerB--;
                              }
                        }
                  }

                  sb = new StringBuilder();

                  if (!result.equals("error")) {
                        sb.append("[");
                        if (dir == 1) {
                              for (int i = pointerF; i <= pointerB; i++) {
                                    sb.append(intArr[i]);
                                    if (i != pointerB) {
                                          sb.append(",");
                                    }
                              }
                        } else if (dir == -1) {
                              for (int i = pointerB; i >= pointerF; i--) {
                                    sb.append(intArr[i]);
                                    if (i != pointerF) {
                                          sb.append(",");
                                    }
                              }
                        }
                        sb.append("]");
                        result = sb.toString();
                  }

                  System.out.println(result);
            }
      }

}
