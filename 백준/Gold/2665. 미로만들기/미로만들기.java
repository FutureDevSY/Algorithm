import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
   static class Pair{
        int x;
        int y;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

static int[][] map;
static boolean[][] visited;
static int N;
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];
    
    for(int i=0; i<N; i++){
        String tmp = br.readLine();
        for(int j=0; j<N; j++){
           map[i][j] = tmp.charAt(j) - '0';
        }
    }
    bfsZeroOrOne();
    bw.write(Integer.toString(map[N-1][N-1]));
    bw.flush();
}
 
static int[] diry = {-1, 0, 1, 0};
static int[] dirx = {0, 1, 0, -1};
private static void bfsZeroOrOne() {    //0-1 bfs
    Deque<Pair> deque = new ArrayDeque<>();
    deque.offerFirst(new Pair(0,0));
    visited[0][0] = true;
    map[0][0] = 0;
    Pair tmpPair = null;
    int dy, dx;
    
    while(!deque.isEmpty()){
        tmpPair = deque.pollFirst();
        if(tmpPair.x == N-1 && tmpPair.y == N-1) return;
        for(int i=0; i<4; i++){
            dy = tmpPair.y + diry[i];
            dx = tmpPair.x + dirx[i];
            if(dy < 0 || dx < 0 || dy >= N || dx >= N || visited[dy][dx]) continue;
            //검은방, 즉 비용이 드는 방은 덱의 뒤에 offer
            if(map[dy][dx] == 1) {
            	deque.offerFirst(new Pair(dy, dx));
            	//이전에 누적된 합 그대로 저장하면 된다
            	map[dy][dx] = map[tmpPair.y][tmpPair.x];
            }
            //검은방이 아니라면 비용x, 덱의 앞에 offer해서 우선권 가짐
            else {
            	deque.offerLast(new Pair(dy, dx));
            	//이전에 누적된 합 + 비용 1 추가
            	map[dy][dx] = map[tmpPair.y][tmpPair.x] + 1;
            }
            visited[dy][dx] = true; 
        }
    }
}
}