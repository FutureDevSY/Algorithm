import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] map;
        char flag;   //1또는 2
        int R, C, N;    //격자 가로,세로,출력할 타이밍

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        String str;
        for (int i=0; i<R; i++){
            str = br.readLine();
            for(int j=0; j<C; j++){
                //앞서 설치되는 폭탄, 1로 우선 표시
                if(str.charAt(j) == 'O'){
                    map[i][j] = '1';
                }
                else map[i][j] = str.charAt(j);
            }
        }

        //두번째 폭탄 설치
        if(N >= 2){
            for (int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] == '1') continue;
                    map[i][j] = '2';
                }
            }
        }

        int time = 3;
        flag = '1';
        //상우하좌
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int ny, nx;
        //N이 1이거나 2면 while문 실행 안하게됨

        while (time <= N){
            if(time % 2 != 0){  //홀수번째 타이밍이라면 폭탄 폭발함
                for (int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        if(map[i][j] == flag){
                            //우선 본인은 터짐
                            map[i][j] = '.';
                            for (int k=0; k<4; k++){
                                ny = i + dy[k];
                                nx = j + dx[k];
                                if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                                if(map[ny][nx] == flag) continue; //이부분 중요!
                                // 같은 폭탄끼리는 우선 터뜨리지 않는다(본인 위치는 터뜨려도 ㄱㅊ)
                                // 동시에 터지는 상황을 가정하기 때문에 해당폭탄 위치들을 알아야하기때문
                                map[ny][nx] = '.';
                            }
                        }
                    }
                }
            }else{  //짝수번째 타이밍이라면 flag번 폭탄 설치
                for (int i=0; i<R; i++){
                    for(int j=0; j<C; j++){
                        //비어있는 위치에 폭탄 설치
                        if(map[i][j] == '.'){
                            map[i][j] = flag;
                        }
                    }
                }
                flag = (flag == '1') ? '2' : '1'; //flag 바꿔줌
            }
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == '1' || map[i][j] == '2'){
                    //숫자는 다시 O로 바꿔준다
                    sb.append('O');
                }else{
                    sb.append(map[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
