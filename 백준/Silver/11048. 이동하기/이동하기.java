import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, M;	//미로 크기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] originMap = new int[N][M];
		int[][] addedMap = new int[N][M];
		int tmp;
		for(int i=0; i<N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmp = Integer.parseInt(st.nextToken());
				originMap[i][j] = tmp;
				addedMap[i][j] = tmp;
			}
		}
		//위에서, 왼쪽에서, 위왼대각에서
		int[] dy = {-1, 0, -1};
		int[] dx = {0, -1, -1};
		
		int tmpMax = -1;
		for(int i=0; i<N; i++ ) {
			for (int j = 0; j < M; j++) {
				if(i == 0 && j == 0) continue;
				for(int k=0; k<3; k++) {
					if(i + dy[k] < 0 || i + dy[k] >= N || j + dx[k] < 0 || j + dx[k] >= M) continue;
					tmpMax = Math.max(tmpMax, addedMap[i][j] + addedMap[i + dy[k]][j + dx[k]]);
				}
				addedMap[i][j] = tmpMax;
				tmpMax = -1;
			}
		}
		
		bw.write(Integer.toString(addedMap[N-1][M-1]));
		bw.flush();
	}

}
