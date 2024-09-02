import java.io.*;
import java.util.StringTokenizer;

public class Main {  //백준 2669번 네 직사각형의 면적 구하기 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = new int[100][100];
        int xs; int xe; int ys; int ye;
        int count = 0;  //배열에 몇번 1이 들어가는지 세줄것임
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs = Integer.parseInt(st.nextToken());  //x좌표 시작점
            ys = Integer.parseInt(st.nextToken());  //y좌표 시작점
            xe = Integer.parseInt(st.nextToken());  //X좌표 끝점
            ye = Integer.parseInt(st.nextToken());  //y좌표 끝점

            for (int x = xs; x < xe; x++) {
                for (int y = ys; y < ye; y++) {
                    if (board[x][y] == 1) { //이미 1이라면 중복되는 부분이라는 의미니까 안세고 넘어감
                        continue;
                    }
                    board[x][y] = 1;
                    count++;
                }
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
