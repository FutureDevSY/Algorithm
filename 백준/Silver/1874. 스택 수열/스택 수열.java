import java.io.*;
import java.util.Stack;

public class Main {    //백준 1874번, 스택 시퀀스 문제
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder howTo = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
//        int[] nums = new int[N];    //N만큼의 배열 생성
//        String howTo = "";  //스택으로 해당 수열 구현하는 과정
//        for (int i = 1; i <= N; i++) {   //1~N의 오름차순 정수를 배열에 저장
//            nums[i-1] = i;
//        }
        int input;  //수열 차례대로의 값이 들어갈 변수
        boolean isPossible = true; //수열 만들어지는지 아닌지
        int nextNum = 1;
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            while (stack.isEmpty() || stack.peek() != input) { //찾는값이 스택의 top에 있을때까지 Push, 있으면 Pop 여기 조건문 뭘로할지 헤맴
                if (stack.isEmpty() || input > stack.peek()) {  //스택이 비어있거나 찾는값보다 top값이 작다면 Push
                    stack.push(nextNum);
                    howTo.append("+" + "\n");
                    nextNum++;
                } else if (!stack.isEmpty() && input < stack.peek()) {  //찾는값보다도 top값이 더 크다면 해당 순열 만들수 없단 얘기
                    isPossible = false;
                    break;
                }   //아..스택에 값이 있는지부터 체크를 하도록 해야되는구나
            }
            if (isPossible && stack.peek() == input) {    //while문을 빠져나와 무사히 top값이 찾는값과 같다면 pop해준다, 여기서 조건문 굳이 써야할까?
                stack.pop();
                howTo.append("-" + "\n");
            } else if (!isPossible) {
                howTo.setLength(0);    //sb 비우는 젤 빠른방법
                howTo.append("NO");
                break;
            }
        }
        //stringBuilder 더 알아보기

        bw.write(howTo.toString());
        bw.newLine();

        bw.flush();
        bw.close();


    }
}
