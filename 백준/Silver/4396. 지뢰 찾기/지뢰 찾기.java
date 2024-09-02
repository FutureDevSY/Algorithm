import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char[][] board;
    static List<Bomb> bombArr;
    static char[][] bombInfo;
    static int N;

    //12시 방향부터 시계방향으로 팔방탐색
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

    static class Bomb{
        //지뢰의 위치정보
        int x;
        int y;

        Bomb(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        //지뢰정보 입력
        bombInfo = new char[N][N];
        board = new char[N][N];
        //지뢰 개수를 모르기때문에 list로 지뢰위치정보 담을것임
        bombArr = new ArrayList<>();
        String str = "";

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                if(str.charAt(j) == '*'){
                    bombArr.add(new Bomb(i, j));
                }
                bombInfo[i][j] = str.charAt(j);
            }
        }
        //열린 칸 정보
        str = "";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 'x'){ //열린곳만 확인하면댐
                    if(bombInfo[i][j] == '*'){
                        //지뢰밟았으면 모든 지뢰위치를 표시함
                        fillWithBomb();
                        continue;
                    }
                    //i,j 위치 기준으로 팔방탐색해서 나온 지뢰개수 입력
                    //아스키코드 관련해서 잘 안외워져서 메소드로 형변환하는 방법 찾아서 함 ㅎ
                    board[i][j] = Character.forDigit(searchDir(i, j), 10);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(board[i][j]);
            }
            bw.newLine();
        }


        bw.close();

    }

    static void fillWithBomb(){
        for (Bomb b : bombArr){
            int x = b.x;
            int y = b.y;
            board[x][y] = '*';
        }
    }

    static int searchDir(int x, int y){
        int xD = x;
        int yD = y;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
           xD = x + dirX[i];
           yD = y + dirY[i];
           //배열범위체크 까먹지마!!
           if(xD < 0 || xD >= N || yD < 0 || yD >= N) continue;
           if(bombInfo[xD][yD] == '*'){
               cnt++;
           }
        }
        return cnt;
    }
}
