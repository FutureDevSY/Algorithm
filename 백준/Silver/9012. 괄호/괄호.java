import java.io.*;

public class Main {  //괄호 문자열 문제, 백준 9012번
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    //입력 문자열 개수

        String str = "";
        char chr;
        String result;
        int isLeft = 0; //닫히지 않은 괄호 남아있다면 마지막에 양수가 남아있을것이고 vps라면 마지막에 0의 값이 될것임

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            isLeft = 0;
            for (int j = 0; j < str.length(); j++) {
                if (isLeft < 0) {
                    break;  //음수가 되었다는건 더 볼필요도 없이 vps가 아닐것
                    //만약 여기서 이렇게 확인을 안한다면 잘못된 결과 나올수도 있을것임 (예를들어 (()))(도 vps라고 하면 안되니까)
                }
                chr = str.charAt(j);
                if (chr == '(') {
                    isLeft++;
                } else if (chr == ')') {
                    isLeft--;
                }
            }

            if (isLeft == 0) {
                bw.write("YES");
                bw.newLine();
            }else{
                bw.write("NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();


    }
}
