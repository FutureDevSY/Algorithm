import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;

        int sticks = Integer.parseInt(br.readLine());
        int[] stickIdx = new int[sticks];   //막대의 개수만큼 각 막대의 왼쪽면 위치를 차례로 저장할 배열
        int[] stickHeight = new int[1001];
        for (int i = 0; i < sticks; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            stickIdx[i] = idx;  //막대수만큼 위치만 따로 저장
            stickHeight[idx] = height;  //각 막대의 왼쪽면 위치를 나타내는 인덱스자리에 높이를 저장
        }
        int container = 0;

        Arrays.sort(stickIdx);  //인덱스가 오름차순으로 안주어져서..정렬해줌

        stack.push(stickIdx[0]);    //일단 첫번째막대인덱스부터 푸시
        for (int i = 1; i < stickIdx.length; i++) {
            if (!stack.isEmpty() && stickHeight[stack.peek()] >= stickHeight[stickIdx[i]]) { //스택의 top원소의 높이가 i높이보다 크거나 같다면
                stack.push(stickIdx[i]);    //스택에 일단 푸시해준다
            } else {    //스택의 top원소의 높이가 더 작다면 이 시점에서 여기까지의 넓이를 재고 pop한다
                while (!stack.isEmpty() && stack.size() > 1 && stickHeight[stack.peek()] <= stickHeight[stickIdx[i]]) {  //새로들어오려는 막대보다 작은애들만 pop해준다 여기서 <=말고 <했다가틀릴뻔
                    stack.pop();
                }
                if (!stack.isEmpty() && stickHeight[stack.peek()] <= stickHeight[stickIdx[i]]) { //이때 넓이 재줄수있음
                    container += (stickIdx[i] - stack.peek()) * stickHeight[stack.peek()];
                    stack.pop();    //넓이 쟀으므로 pop해없앰
                    stack.push(stickIdx[i]);
                } else if (!stack.isEmpty() && stickHeight[stack.peek()] > stickHeight[stickIdx[i]]) {
                    stack.push(stickIdx[i]);    //남아있는 원소보다 i가 더 작으면 i를 푸시만해준다
                }
            }
        }
        //마지막막대까지 다 push되었다면 남아있는애들 넓이 따로 구해주기
        while (!stack.isEmpty()) {     //스택에 원소 남아있다면
            if (stack.size() == 1) {  //스택에 원소 하나만 남아있었다면
                container += stickHeight[stack.pop()];
            } else {
                int tmp = stack.pop();
                container += ((tmp + 1) - (stack.peek() + 1)) * stickHeight[tmp];
            }
        }
        bw.write(Integer.toString(container));
        bw.flush();
        bw.close();
    }
}
