import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    //테스트 케이스 수 입력

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());    //각 줄에 입력받을 정수의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] stickers = new int[2][N];   //2열 N행의 2차원 배열 생성
            for (int i = 0; i < N; i++) {   //첫번째 행 원소 입력
                stickers[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {   //두번째 행 원소 입력
                stickers[1][i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][N];

            for (int i = 0; i < N; i++) {   //두번째 행 원소 입력
                if (i == 0) {   //dp배열의 첫 열에는 원래 점수를 그대로 넣는다
                    dp[0][0] = stickers[0][0];
                    dp[1][0] = stickers[1][0];
                } else if (i == 1) {    //dp배열의 두번째 열에는 바로 대각선상의 점수와 자신의 점수를 더한다(여기까지는 이게 최선임)
                    dp[0][1] = stickers[1][0] + stickers[0][1];
                    dp[1][1] = stickers[0][0] + stickers[1][1];
                } else {//대각선에 있는 dp값 or 대각선에서 옆에 있는 dp값중 더 큰 dp값과 자신의 점수 더한다
                    dp[0][i] = Math.max((dp[1][i - 1]), (dp[1][i - 2])) + stickers[0][i];
                    dp[1][i] = Math.max((dp[0][i - 1]), (dp[0][i - 2])) + stickers[1][i];
                }
            }
            bw.write(Integer.toString(Math.max(dp[0][N-1], dp[1][N-1])));   //맨 마지막 열의 두 값을 비교해 더 큰값 출력
            bw.newLine();
        }//전체for문

        bw.flush();
        bw.close();
    }
}
