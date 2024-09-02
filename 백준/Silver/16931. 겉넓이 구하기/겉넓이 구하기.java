import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sum = 0;
		int tmp = 0;
		
		//left, right 시점 구하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(M - j - 2 < 0) sum += map[i][M - j - 1];
				else {
					//비교할 위치값과 차를 구하는데 양수가 나오면 그 값만 더한다
					tmp = map[i][M - j - 1] - map[i][M - j - 2];
					if(tmp > 0 ) sum += tmp;
				}
				if(j + 1 >= M) sum += map[i][j];
				else {
					//비교할 위치값과 차를 구하는데 양수가 나오면 그 값만 더한다
					tmp = map[i][j] - map[i][j + 1];
					if(tmp > 0 ) sum += tmp;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(N - j - 2 < 0) sum += map[N - j - 1][i];
				else {
					//비교할 위치값과 차를 구하는데 양수가 나오면 그 값만 더한다
					tmp = map[N - j - 1][i] - map[N - j - 2][i];
					if(tmp > 0 ) sum += tmp;
				}
				
				if(j + 1 >= N) sum += map[j][i];
				else {
					//비교할 위치값과 차를 구하는데 양수가 나오면 그 값만 더한다
					tmp = map[j][i] - map[j + 1][i];
					if(tmp > 0 ) sum += tmp;
				}
			}
		}
        
		sum += 2 * (N*M);
		bw.write(Integer.toString(sum));
		bw.flush();

	}

}
