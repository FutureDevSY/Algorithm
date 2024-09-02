import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int y; int x; int cnt;
	Node(int y, int x, int cnt){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class Main {
	static int[][] map;
	static boolean[][] visited;
	//상우하좌
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int N, M, endY, endX;

	public static void main(String[] args) throws IOException{
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//1.1에서 좌표 N.M으로 이동, 배열 크기 의미하기도
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		endY = N - 1;
		endX = M - 1;
		
		bw.write(Integer.toString(bfs(0,0,0) + 1));
		bw.close();	
		
	}

	private static int bfs(int y, int x, int cnt) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(y, x, cnt));	//시작노드, 0.0
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Node tmpNode = queue.poll();
			for(int i=0; i<4; i++) {
				if(tmpNode.y == endY && tmpNode.x == endX) {
					return tmpNode.cnt;
				}
				int ty = tmpNode.y + dy[i];
				int tx = tmpNode.x + dx[i];
				if(ty < 0 || ty >= N || tx < 0 || tx >= M) continue;
				if(map[ty][tx] == 1) {
					//이미 이전에 cnt를 구해놓았다면 갱신하지 않는다
					if(visited[ty][tx]) continue;
					visited[ty][tx] = true;
					queue.add(new Node(ty, tx, tmpNode.cnt + 1));
				}
				
			}
		}
		return -1;
	}

}
