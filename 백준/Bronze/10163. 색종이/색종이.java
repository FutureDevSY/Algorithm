import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main { //백준 색종이 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    //색종이 개수
        int[][] board = new int[1001][1001];
        int width;
        int height;
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());   //행
            int x = 1000 - Integer.parseInt(st.nextToken());    //열
            width = Integer.parseInt(st.nextToken());   //가로넓이
            height = Integer.parseInt(st.nextToken());  //세로높이
            for (int i = x; i > x - height; i--) {
                for (int j = y; j < y + width; j++) {
                    board[i][j] = t;
                }
            }
        }
        int[] check = new int[T+1];
        for (int t = 1; t <= T; t++) {
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (board[i][j] == t) {
                        check[t]++;
                    }
                }
            }
        }
        for (int t = 1; t <= T; t++) {
            bw.write(Integer.toString(check[t]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
