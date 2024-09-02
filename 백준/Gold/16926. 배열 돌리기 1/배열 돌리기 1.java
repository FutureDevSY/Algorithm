import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, rotateCnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //배열 크기 NxM (열 개수, 행 개수)
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        rotateCnt = Integer.parseInt(st.nextToken());  //회전수
        map = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateMap();
        printMap();
        bw.close();
    }
    private static void printMap() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
    private static void rotateMap() {
        //오 아 왼 위 방향순
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int loopCount = Math.min(R, C) / 2;
        int ny, nx; //교환할 방향에 있는 원소

        for(int i = 0; i < rotateCnt; i++){     //총 회전횟수
            for(int j = 0; j < loopCount; j++){     //돌려야 할 각 레이어 갯수
                int tmp = map[j][j];  //시작점 원소값 저장해둠
                //0,0, 1,1 식으로 시작점이 t,t와 같음
                int y = j;
                int x = j;

                for(int k = 0; k<4; k++){
                    while(true){
                        ny = y + dy[k];
                        nx = x + dx[k];
                        if(ny < j || nx < j || nx >= C - j || ny >= R - j) break;

                        map[y][x] = map[ny][nx];
                        y = ny;
                        x = nx;
                    }
                }
                map[j + 1][j] = tmp;

            }
        }
    }
}
