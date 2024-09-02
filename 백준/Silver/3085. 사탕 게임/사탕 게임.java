import java.io.*;

public class Main {    //백준 3085번 사탕 게임 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //NxN 크기의 보드 크기
        char[][] candyBoard = new char[N][N];   //C P Z Y 네가지가 저장
        String str;
        //2차원 배열에 사탕 정보부터 저장
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                candyBoard[i][j] = str.charAt(j);
            }
        }

        //가로 방향으로 바꾸는 경우
        char temp;
        int comboRow = 0;  //가장 긴 연속되는 같은 종류 사탕의 길이(행 기준)
        int comboCol = 0;  //가장 긴 연속되는 같은 종류 사탕의 길이(열 기준)
        char candyNow = 'C';  //현재 보고있는 사탕의 종류
        int comboMax = 0;   //가장 긴 길이
        for (int i = 0; i < N; i++) { //총 N행에 대하여 바꿔본다
            for (int j = 0; j < N - 1; j++) {   //마지막 N-1번째 사탕은 오른쪽과 교환x
                //오른쪽과 교환과정
                temp = candyBoard[i][j];
                candyBoard[i][j] = candyBoard[i][j + 1];
                candyBoard[i][j + 1] = temp;

                //가장 긴 사탕의 길이 구하기(행)
                for (int k = 0; k < N; k++) {
                    comboRow = 0;
                    for (int h = 0; h < N; h++) {
                        if (h == 0) {
                            candyNow = candyBoard[k][h];    //첫 사탕정보 일단 저장
                            comboRow++;    //일단 1개
                        } else {
                            if (candyBoard[k][h] == candyNow) {    //현재위치의 사탕이 이전 저장된 사탕과 같은종류라면
                                comboRow++;
                                if(comboRow > comboMax) comboMax = comboRow;
                            } else {
                                if(comboRow > comboMax) comboMax = comboRow;    //새로 들어가기 전에, 이전 콤보보다 크다면 갱신
                                comboRow = 1;  //1로 되돌아감
                                candyNow = candyBoard[k][h];    //새로운 사탕정보 등록
                            }
                        }
                    }
                }

                //가장 긴 사탕의 길이 구하기(열)
                for (int k = 0; k < N; k++) {
                    comboCol = 0;
                    for (int h = 0; h < N; h++) {
                        if (h == 0) {
                            candyNow = candyBoard[h][k];    //첫 사탕정보 일단 저장
                            comboCol++;    //일단 1개
                        } else {
                            if (candyBoard[h][k] == candyNow) {    //현재위치의 사탕이 이전 저장된 사탕과 같은종류라면
                                comboCol++;
                                if(comboCol > comboMax) comboMax = comboCol;
                            } else {
                                if(comboCol > comboMax) comboMax = comboCol;    //새로 들어가기 전에, 이전 콤보보다 크다면 갱신
                                comboCol= 1;  //1로 되돌아감
                                candyNow = candyBoard[h][k];    //새로운 사탕정보 등록
                            }
                        }
                    }
                }
                //확인했으면 다시 원위치로 돌려놓는다
                temp = candyBoard[i][j];
                candyBoard[i][j] = candyBoard[i][j + 1];
                candyBoard[i][j + 1] = temp;
            }
        }

        //세로 방향으로 바꾸는 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                //아래쪽과 교환과정
                if(candyBoard[j][i] == candyBoard[j + 1][i]) continue;
                temp = candyBoard[j][i];
                candyBoard[j][i] = candyBoard[j + 1][i];
                candyBoard[j + 1][i] = temp;

                //가장 긴 사탕의 길이 구하기(행)
                for (int k = 0; k < N; k++) {
                    comboRow = 0;
                    for (int h = 0; h < N; h++) {
                        if (h == 0) {
                            candyNow = candyBoard[k][h];    //첫 사탕정보 일단 저장
                            comboRow++;    //일단 1개
                        } else {
                            if (candyBoard[k][h] == candyNow) {    //현재위치의 사탕이 이전 저장된 사탕과 같은종류라면
                                comboRow++;
                                if(comboRow > comboMax) comboMax = comboRow;
                            } else {
                                if(comboRow > comboMax) comboMax = comboRow;    //새로 들어가기 전에, 이전 콤보보다 크다면 갱신
                                comboRow = 1;  //1로 되돌아감
                                candyNow = candyBoard[k][h];    //새로운 사탕정보 등록
                            }
                        }
                    }
                }

                //가장 긴 사탕의 길이 구하기(열)
                for (int k = 0; k < N; k++) {
                    comboCol = 0;
                    for (int h = 0; h < N; h++) {
                        if (h == 0) {
                            candyNow = candyBoard[h][k];    //첫 사탕정보 일단 저장
                            comboCol++;    //일단 1개
                        } else {
                            if (candyBoard[h][k] == candyNow) {    //현재위치의 사탕이 이전 저장된 사탕과 같은종류라면
                                comboCol++;
                                if(comboCol > comboMax) comboMax = comboCol;
                            } else {
                                if(comboCol > comboMax) comboMax = comboCol;    //새로 들어가기 전에, 이전 콤보보다 크다면 갱신
                                comboCol = 1;  //1로 되돌아감
                                candyNow = candyBoard[h][k];    //새로운 사탕정보 등록
                            }
                        }
                    }
                }
                //다시 원위치로
                temp = candyBoard[j][i];
                candyBoard[j][i] = candyBoard[j + 1][i];
                candyBoard[j + 1][i] = temp;
            }
        }
        bw.write(Integer.toString(comboMax));
        bw.flush();
        bw.close();
    }
}
