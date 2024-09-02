import java.io.*;
import java.util.StringTokenizer;

public class Main {    //백준 14500 테트로미노 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {   //배열의 행
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int temp = 0 ;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //가로 막대 모양
                if (j + 3 < M) {
                    temp = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3];
                    if(temp > max) max = temp;
                }
                //세로 막대 모양
                if (i + 3 < N) {
                    temp = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j];
                    if(temp > max) max = temp;
                }
                //ㅁ자 막대 모양
                if (i + 1 < N && j + 1 < M) {
                    temp = board[i][j] + board[i + 1][j] + board[i][j + 1] + board[i + 1][j + 1];
                    if(temp > max) max = temp;
                }
                //ㄴ자 막대 모양 - 기본 ㄴ자
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1];
                    if(temp > max) max = temp;
                }
                //ㄴ자 막대 모양 - 좌우반전
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i+2][j] + board[i][j+1] + board[i+1][j + 1] + board[i + 2][j + 1];
                    if(temp > max) max = temp;
                }
                //ㄴ자 막대 모양 - 상하반전
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i][j + 1];
                    if(temp > max) max = temp;
                }
                //ㄴ자 막대 모양 - 상하반전 & 좌우반전
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+2][j + 1];
                    if(temp > max) max = temp;
                }
                //5. ㄴ자 막대 모양 - 오른쪽 회전 1번
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j] + board[i+1][j] + board[i][j+1] + board[i][j + 2];
                    if(temp > max) max = temp;
                }
                //6. ㄴ자 막대 모양 - 5에서 상하반전
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+1][j + 2];
                    if(temp > max) max = temp;
                }
                //7. ㄴ자 막대 모양 - 6에서 좌우반전
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i+1][j] + board[i+1][j+1] + board[i+1][j+2] + board[i][j + 2];
                    if(temp > max) max = temp;
                }
                //8. ㄴ자 막대 모양 - 7에서 상하반전
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j + 2];
                    if(temp > max) max = temp;
                }
                //z자 막대 모양 - 1
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j] + board[i+1][j] + board[i+1][j+1] + board[i+2][j + 1];
                    if(temp > max) max = temp;
                }
                //z자 막대 모양 - 2
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j];
                    if(temp > max) max = temp;
                }
                //z자 막대 모양 - 3
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i+1][j] + board[i][j+1] + board[i+1][j+1] + board[i][j + 2];
                    if(temp > max) max = temp;
                }
                //z자 막대 모양 - 4
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j] + board[i][j+1] + board[i+1][j+1] + board[i+1][j + 2];
                    if(temp > max) max = temp;
                }
                //ㅗ자 막대 모양 - 기본
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+1][j + 2];
                    if(temp > max) max = temp;
                }
                //ㅜ자 막대 모양 - (상하반전)
                if (i + 1 < N && j + 2 < M) {
                    temp = board[i][j] + board[i][j+1] + board[i][j+2] + board[i+1][j + 1];
                    if(temp > max) max = temp;
                }
                //ㅏ자 막대 모양 - (회전)
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+1][j + 1];
                    if(temp > max) max = temp;
                }
                //ㅓ자 막대 모양 - (회전)
                if (i + 2 < N && j + 1 < M) {
                    temp = board[i][j+1] + board[i+1][j] + board[i+1][j+1] + board[i+2][j + 1];
                    if(temp > max) max = temp;
                }


            }

        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
