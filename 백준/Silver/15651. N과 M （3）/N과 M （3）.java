import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[M];
		
		//1~N까지의 숫자중 M개의 수열을 출력, 중복되는 수는 ㅇㅋ 그치만 수열이 중복되면 ㄴ
		dfs(0);
		bw.close();
	}
	private static void dfs(int cnt) throws IOException{
		if(cnt >= M) {
			for(int i : nums) {
				bw.write(i + " ");
			}
			bw.newLine();
			return;
		}
		for(int i=1; i<=N; i++) {
			nums[cnt] = i;
			dfs(cnt + 1);
		}
	}
	
	
}
