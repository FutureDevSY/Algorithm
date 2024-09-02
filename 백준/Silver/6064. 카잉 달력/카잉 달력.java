import java.io.*;
import java.util.StringTokenizer;

public class Main {    //백준 6064번 카잉달력 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    //입력받을 테스트케이스 수
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());   //x년도의 범위:1~M
            int N = Integer.parseInt(st.nextToken());   //y년도의 범위:1~N
            int X = Integer.parseInt(st.nextToken());   //x년도
            int Y = Integer.parseInt(st.nextToken());   //y년도

            int count = -1;
            X -= 1; Y -= 1;   //둘다 1씩 뺴서 생각한다.왜냐면..나머지를 이용해야하는데 N이 5고 Y가 5인 경우 나머지가 0이나오기때문
            for (int j=X; j<N*M; j+=M) {    //X에서 시작, M만큼씩 건너뛰며 확인한다
                if (j % N == Y) { //j에서 n을나눈 나머지가 y가 된다면 그게 답
                    count = j + 1;  //애초에 -1해서 생각했으니 다시 1을 더한값이 원래 값이 된다
                    break;
                }
            }
            bw.write(Integer.toString(count));
            bw.newLine();


        }
        bw.flush();
        bw.close();
    }
}
