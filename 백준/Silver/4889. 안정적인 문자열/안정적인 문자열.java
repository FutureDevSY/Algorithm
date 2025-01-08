import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            int testCaseNum = 0;
            while(!input.contains("-")){
                  testCaseNum++;
                  // [[ [뒤에 [있으면 1
                  // ]] ]뒤에 ]있으면 1
                  // ][ [뒤에 ]있으면 2 (서로다르면 2)
                  char popped;
                  int score = 0;
                  int rightCnt = 0;
                  for(int i=0; i<input.length(); i++){
                        if(input.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
                              stack.pop();
                              continue;
                        }else stack.add(input.charAt(i));
                  }

                  int count = 0;
                  while(!stack.isEmpty()){
                        popped = stack.pop();
                        if(popped == '{'){
                              if(stack.pop() == '{') count++;
                              else count = count + 2;
                        }else {
                         count++;
                         stack.pop();
                        }
                  }

                  bw.write(testCaseNum + ". " + count);
                  bw.write('\n');

                  stack.clear();
                  input = br.readLine();
            }

            bw.close();
      }

}
