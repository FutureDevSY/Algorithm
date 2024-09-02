import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String str;
	static StringBuilder sb = new StringBuilder();
	static int[][] spaces;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		spaces = new int[N][N];
		
		char[] chrArr = new char[N];
		for(int i=0 ;i<N; i++) {
			chrArr = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				spaces[i][j] = chrArr[j] - '0';
			}
		}
		
		makeSpace(0,0,N);
		System.out.println(sb);
	}
	
	private static void makeSpace(int sr, int sc, int size) {
			int sum = 0;
			for(int r = sr; r < sr + size; r++) {
				for(int c = sc; c < sc + size; c++) {
					sum += spaces[r][c];
				}
			}
			if(sum == 0) {	//해당 영역이 다 0
				sb.append("0");

			}else if(sum == size * size) {	//해당 영역이 다 1
				sb.append("1");
			}else { //섞여있는경우
				sb.append("(");
				int half = size/2;
				//각 사각형의 가장 상단 왼쪽으로
				makeSpace(sr, sc, half);	//1번공간 (1/4)
				
				makeSpace(sr, sc+half, half);	//1번공간 (1/4)
				
				makeSpace(sr+half, sc, half);	//1번공간 (1/4)
				
				makeSpace(sr+half, sc+half, half);	//1번공간 (1/4)
				
				sb.append(")");
			}
	}
}
