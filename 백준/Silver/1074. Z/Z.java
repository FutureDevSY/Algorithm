import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//2^N크기의 배열
		N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		findFourSpaces(0, 0, 0);
		
		bw.write(Integer.toString(result));
		bw.close();
				
	}
	
	//사방탐색..? seq는 각 사각형의 시작점 기준에서의 첫 순서
	public static void findFourSpaces(int startY, int startX, int seq) {
		if(N == 1) {	//더이상 4분할로 쪼개질수 없으면 답이 정해진다
			if(startY == c && startX == r) {
				result = seq;
				return;
			}
		}
		
		N = N/2;
	
		int sq1Y = startY;
		int sq1X = startX;
		int sq2Y = startY;
		int sq2X = startX + N;
		int sq3Y = startY + N;
		int sq3X = startX;
		int sq4Y = startY + N;
		int sq4X = startX + N;

		
		if(c >= sq1Y && c <= (sq1Y + (N - 1)) && r >= sq1X && r <= (sq1X + (N - 1))){
			findFourSpaces(sq1Y, sq1X, seq);
		}else if(c >= sq2Y && c <= (sq2Y + (N - 1)) && r >= sq2X && r <= (sq2X + (N - 1))){
			findFourSpaces(sq2Y, sq2X, seq + (N*N));
		}else if(c >= sq3Y && c <= (sq3Y + (N - 1)) && r >= sq3X && r <= (sq3X + (N - 1))){
			findFourSpaces(sq3Y, sq3X, seq + (N*N*2));
		}else if(c >= sq4Y && c <= (sq4Y + (N - 1)) && r >= sq4X && r <= (sq4X + (N - 1))){
			findFourSpaces(sq4Y, sq4X, seq + (N*N*3));
		}

		
	}
	

}
