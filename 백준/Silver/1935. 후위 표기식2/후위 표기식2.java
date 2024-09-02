import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Double> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //피연산자 개수
        char[] charArr = br.readLine().toCharArray();
        int[] whatNum = new int[N]; //A부터 시작하는 피연산자들에 각 대응되는 수들
        for (int i = 0; i < N; i++) whatNum[i] = Integer.parseInt(br.readLine());

        double tmp1, tmp2;
        for (int i=0; i<charArr.length; i++){
            if(charArr[i] >= 'A' && charArr[i] <= 'Z'){     //A~Z의 피연산자 값이라면 일단 Push
                stack.push((double)whatNum[(int)charArr[i] - 65]);
            }else{
                if(charArr[i] == '*'){
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 * tmp1);    //연산결과 다시 Push
                }else if(charArr[i] == '/'){
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 / tmp1);
                }else if(charArr[i] == '+'){
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 + tmp1);
                }else if(charArr[i] == '-'){
                    tmp1 = stack.pop();
                    tmp2 = stack.pop();
                    stack.push(tmp2 - tmp1);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
