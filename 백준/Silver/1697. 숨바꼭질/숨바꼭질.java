
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class NodeInfo{
	int data;
	int count;
	boolean isChecked;
	NodeInfo(int data, int count){
		this.data = data;
		this.count = count;
		
	}
}



public class Main {
	static int N, K, result;
	static boolean[] isChecked;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int tmp = Math.max(N, K);
		if(tmp == 0) tmp = 1;
		isChecked = new boolean[tmp * 2];
		
		bfs();
		
		bw.write(Integer.toString(result));
		bw.close();
			
	}
	
	private static void bfs() {
		Queue<NodeInfo> q = new ArrayDeque<>();
		NodeInfo tmp = new NodeInfo(N,0);
		isChecked[tmp.data] = true;
		q.add(tmp);
		
		while(!q.isEmpty()) {
			tmp = q.poll();
			if(tmp.data == K) {
				result = tmp.count;
				return;
			} 
			if(tmp.data - 1 >= 0 && !isChecked[tmp.data - 1]) {
				q.add(new NodeInfo(tmp.data-1, tmp.count+1));
				isChecked[tmp.data-1] = true;
			} 
			if(tmp.data + 1 < isChecked.length && !isChecked[tmp.data + 1]) {
				q.add(new NodeInfo(tmp.data+1, tmp.count+1));
				isChecked[tmp.data+1] = true;
			} 
			if(tmp.data * 2 < isChecked.length && !isChecked[tmp.data * 2]) {
				q.add(new NodeInfo(tmp.data*2, tmp.count+1));
				isChecked[tmp.data*2] = true;
			} 
		}
	}
	

}
