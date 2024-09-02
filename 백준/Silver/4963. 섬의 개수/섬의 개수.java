import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, count;
	static int[][] map;
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringTokenizer st;
//	     String endLine = br.readLine();   
	     
	     while(true) {
	    	 st = new StringTokenizer(br.readLine());
	    	 w = Integer.parseInt(st.nextToken());
	    	 h = Integer.parseInt(st.nextToken());
	    	 if(w == 0 && h == 0) break;
	    	 map = new int[h][w];
	    	 visited = new boolean[h][w];
	    	 
	    	 for(int i=0; i<h; i++) {
	    		 st = new StringTokenizer(br.readLine());
	    		 for(int j=0; j<w; j++) {
	    			 map[i][j] = Integer.parseInt(st.nextToken());
	    		 }
	    	 }
	    	 
	    	 for(int i=0; i<h; i++) {  	
	    		 for(int j=0; j<w; j++) {
	    			 if(map[i][j] == 1 && !visited[i][j]) {	//땅이면
	    				 bfs(i,j);
	    				 count++;
	    			 }
	    		 }
	    	 }
	    	 
	    	 System.out.println(count);
	    	 count = 0;
	     }
		


	}
	
	//상, 상우, 우, 우하, 하, 좌하, 좌, 상좌
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static class Pair{
		int y, x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		
		}
	}
	
	private static void bfs(int y, int x) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(y,x));
		visited[y][x] = true;
		int ny, nx;
		Pair tmpPair;
		
		while(!q.isEmpty()) {
			tmpPair = q.poll();
			for(int i=0; i<8; i++) {
				ny = tmpPair.y + dy[i];
				nx = tmpPair.x + dx[i];
				if(ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] != 1 || visited[ny][nx]) continue;
				q.add(new Pair(ny, nx));
				visited[ny][nx] = true;
			}
			
		}
		
		
	}

}
