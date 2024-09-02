import java.io.*;
import java.util.StringTokenizer;

public class Main { //백준 1107번 리모컨 문제
    static boolean[] broken = new boolean[10]; //고장난 버튼을 표시할 배열, 기본값:false , static을 붙여 생성없이 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int channel = Integer.parseInt(br.readLine());  //목적지 채널
        int M = Integer.parseInt(br.readLine());    //고장난 버튼 개수

        if (M > 0) {    //고장난 버튼 개수가 0이 들어오는 경우 대비
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {   //고장난 버튼 정보를 true로 설정
                int m = Integer.parseInt(st.nextToken());
                broken[m] = true;
            }
        }

        int pressPlusOrMinus;   //추가적으로 눌러야 할 플러스/마이너스 버튼
        int pressCountResult = channel - 100;   //초기값은 그냥 플/마 버튼만 눌러서 가는 횟수로 해준다(채널 100에서 시작이므로 100빼줌)
        if (pressCountResult < 0) { //음수면 양수값으로
            pressCountResult = -pressCountResult;
        }

        int length;
        for (int i = 0; i <= 1000000; i++) {
            length = (Integer.toString(i)).length();
            if (isPossible(i)) {    //이동가능한 채널이라면
                pressPlusOrMinus = channel - i; //목적지 채널과의 차를 구한다 (추가적으로 눌러야 할 +or-버튼횟수)
                if (pressPlusOrMinus < 0) { //음수면 반대로 음수를 붙여 양수로 만들어줌
                    pressPlusOrMinus = -pressPlusOrMinus;
                }
                if (pressCountResult > pressPlusOrMinus + length) { //i의 자릿수만큼 누른 횟수 + 추가적으로 누를 +or-버튼횟수의 합과 비교
                    pressCountResult = pressPlusOrMinus + length;
                }
            }
        }
        bw.write(Integer.toString(pressCountResult));
        bw.flush();
        bw.close();
    }

    static boolean isPossible(int i){
        if (i == 0) {   //0은 따로 체크해준다
            return !broken[0];
        }
        while (i > 0) {
            int check = i % 10;
            if (broken[check]) {    //고장난 버튼이 포함된 수여서 이동불가능
                return false;
            }
            i = i / 10;
        }
        return true;
    }

}
