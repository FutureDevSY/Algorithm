import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());	//사과 개수
		for(int i=0; i<K; i++) {
			int y, x;
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y - 1][x - 1] = 2;	//사과 위치에 2로 표시
		}
		
		int L = Integer.parseInt(br.readLine());	//뱀의 방향전환횟수
		int[] turnTime = new int[L];	//l초 후에 방향전환
		String[] turnDir = new String[L];	//l초 후에 전환할 방향, D면 오른쪽 L면 왼쪽
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			turnTime[i] = Integer.parseInt(st.nextToken());
			turnDir[i] = st.nextToken();
		}
		
		int timing = 0;
		int[] head = {0, 0};	//뱀의 머리 좌표
		int[] tail = {0, 0};	//뱀의 꼬리 좌표
		
		//회전시키는 방향: 오른쪽으로 회전하려면 증가하는 방향으로/왼쪽으로 회전하려면 감소하는(반대)방향으로
		int[] diry = {-1, 0, 1, 0};		//방향: 위 오 아래 왼
		int[] dirx = {0, 1, 0, -1};
		int curDir = 1;	//현재 뱀이 바라보고 있는 방향(처음:오른쪽방향)
		
		int curTime = 0;
		Deque<Pair> deque = new ArrayDeque<>();	//꼬리위치 기억
		deque.addFirst(new Pair(0,0));
		map[0][0] = 1;
		
		while(true) {
			curTime++;
			
			//뱀 머리위치 갱신 
			head[0] = head[0] + diry[curDir];
			head[1] = head[1] + dirx[curDir];
			deque.addFirst(new Pair(head[0], head[1]));
			
			//뱀 머리가 벽에 부딪히거나 꼬리에 부딪히는지 확인
			if(head[0] >= N || head[1] >= N || head[0] < 0 || head[1] < 0) break;
			if(map[head[0]][head[1]] == 1) break;
			
			
			//map위치에 사과가 없다면 뱀 꼬리 삭제, 새로운 꼬리 좌표 할당
			if(map[head[0]][head[1]] != 2) {
				//이동한 머리 위치에 값 1 
				map[head[0]][head[1]] = 1;
				
				map[tail[0]][tail[1]] = 0;
				Pair p = deque.pollLast();
				p = deque.getLast();
				tail[0] = p.y;
				tail[1] = p.x;
				
			}
			//이동한 머리 위치에 값 1 
			map[head[0]][head[1]] = 1;
			
			//방향전환 여부 
			if(timing < L && turnTime[timing] == curTime) {
				if(turnDir[timing].equals("D")) {	//오른쪽 회전
					//dir배열 증가하는 방향으로 방향전환
					curDir = (curDir + 4 + 1) % 4;
				}else if(turnDir[timing].equals("L")) {	//왼쪽 회전
					curDir = (curDir + 4 - 1) % 4;
				}
				timing++;
			}
			
		
		}
		bw.write(Integer.toString(curTime));
		bw.flush();
	}
}
