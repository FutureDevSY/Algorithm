import java.io.*;

public class Main { //백준 1748번 수 이어쓰기 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String strN = Integer.toString(N);
        int len = strN.length();    //N의 자릿수
        int count = 0;

        if (len > 1) { //2자리수 이상이라면
            for (int i = len - 1; i > 1; i--) {     //(N-1)자리수~2자리수. 2자리수 이하라면 for문 건너뜀
                count += (9 * Math.pow(10, i - 1)) * i;
            }
            count += 9; //한자리 수들도 더해준다
            count += (N - (Math.pow(10, len - 1)) + 1) * len;
        } else {    //N이 한자리수라면
            count = N;  //N이 그대로 자릿수가 된다
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
