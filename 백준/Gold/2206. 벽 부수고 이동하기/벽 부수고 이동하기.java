
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Stream;

public class Main {  //벽 부수기 문제

    static class Pair {
        int x, y, count, isBroken;
        Pair(int y, int x, int count, int isBroken){
            this.y = y;
            this.x = x;
            this.count = count;
            this.isBroken = isBroken;
        }
    }

    static int N, M, minCount;    //맵 크기
    static int[][] originMap;
    static int[][] brokenMap;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());	//세로길이
        M = Integer.parseInt(st.nextToken());
        originMap = new int[N][M];
        List<Pair> wall = new ArrayList<>();

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == '1') wall.add(new Pair(i,j,0,1));   //벽위치 저장
                originMap[i][j] = str.charAt(j) - '0';
            }
        }

        minCount = Integer.MAX_VALUE;
        bfs();

        if(minCount == Integer.MAX_VALUE) minCount = -1;
        if(N == 1 && M == 1) minCount = 1;
        bw.write(Integer.toString(minCount));
        bw.flush();

    }
    
    private static void bfs(){
        boolean[][] visit = new boolean[N][M];
        boolean[][] brokenVisit = new boolean[N][M];
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,1,0));
        visit[0][0] = true;
        
        int ny, nx, status;	//status는 부쉈으면 1, 안부쉈으면 0

        while (!q.isEmpty()){
            Pair pair = q.poll();
            
            if(pair.y == N-1 && pair.x == M-1) {
	              minCount = Math.min(minCount, pair.count);
//	              return;
	        }
            
            for(int i = 0; i < 4; i++){
                ny = pair.y + dy[i];
                nx = pair.x + dx[i];
                
                if(ny < 0 || nx < 0 || nx >= M || ny >= N) continue;
//                if(ny == N-1 && nx == M-1){
//                    minCount = Math.min(minCount, pair.count + 1);
//                    return;
//                }
                
                status = pair.isBroken;
                
                if(status == 0) {
                	if(visit[ny][nx]) continue;
                	if(originMap[ny][nx] == 1) status = 1;
                	visit[ny][nx] = true;
                	q.add(new Pair(ny, nx, pair.count + 1, status));
                } else if(status == 1) {	//부수고 온 경우
                	if(brokenVisit[ny][nx]) continue;
                	if(originMap[ny][nx] == 1) continue;
                	brokenVisit[ny][nx] = true;
                	q.add(new Pair(ny, nx, pair.count + 1, status));
                }
            }

        }

    }
}