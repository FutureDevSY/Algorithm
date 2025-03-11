import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            String bomb = br.readLine();
            int bombLng = bomb.length();

            Stack<Character> stack= new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  stack.add(str.charAt(i));

                  //폭발문자열 길이 이상이 되면 체크
                  if(stack.size() >= bombLng){
                        int combo = 0;
                        out : for (int j = 0; j < bombLng; j++) {
                              if(stack.get(j + (stack.size() - bombLng)) == bomb.charAt(j)){
                                    combo++;
                              }
                              if(combo >= bombLng){
                                    for (int k = 0; k < bombLng; k++) {
                                          stack.pop();
                                    }
                                    break out;
                              }
                        }
                  }
            }
            if(stack.isEmpty()) System.out.println("FRULA");
            else{
                  StringBuilder sb = new StringBuilder();
                  for(char s : stack){
                        sb.append(s);
                  }
                  System.out.println(sb);
            }

      }

}
