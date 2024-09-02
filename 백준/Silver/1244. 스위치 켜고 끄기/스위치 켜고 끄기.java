import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] onAndOff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int SwitchNum = Integer.parseInt(br.readLine());    //스위치 개수
        onAndOff = new int[SwitchNum+1];  //0,1로 표시될 스위치 초기상태
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= SwitchNum; i++) {
            onAndOff[i] = Integer.parseInt(st.nextToken());
        }
        int studNum = Integer.parseInt(br.readLine());  //학생수

        for (int i = 0; i < studNum; i++) { //학생수만큼 boy또는 girl연산 반복
            st = new StringTokenizer(br.readLine());
            int bOrg = Integer.parseInt(st.nextToken());    //학생의 성별
            int X = Integer.parseInt(st.nextToken());   //학생이 받은 수
            if (bOrg == 1) {    //남학생이라면
                boy(X);
            } else if (bOrg == 2) {     //여학생이라면
                girl(X);
            }
        }

        for (int i = 1; i < onAndOff.length; i++) {     //스위치 상태결과 20개씩 끊어서 출력
            if (i > 1 && i % 20 == 1) {
                bw.newLine();
            }
            bw.write(onAndOff[i] + " ");
        }
        bw.flush();
        bw.close();

    }
    static void boy(int x) {
        int tmp = x;
        while (x < onAndOff.length) {
            onAndOff[x] = onAndOff[x]== 0 ? 1 : 0;    //조건부 연산자는 이렇게 쓴다. 0<->1로 변경
            x += tmp;
        }
    }

    static void girl(int x) {   //스택으로 하려다 괜히 복잡하게 한것같아 수정
        int left = x - 1;
        int right = x + 1;
        onAndOff[x] = onAndOff[x] == 0 ? 1 : 0; //일단 x위치의 스위치 값은 바꿔준다
        while (left > 0 && right < onAndOff.length) {   //0번인덱스는 보지않아야함
            if (onAndOff[left] == onAndOff[right]) {
                onAndOff[left] = onAndOff[left] == 0 ? 1 : 0;
                onAndOff[right] = onAndOff[right] == 0 ? 1 : 0;
            } else {
                break;
            }
            left--;
            right++;
        }
    }
}
