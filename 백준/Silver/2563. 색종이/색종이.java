import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int paperCount = Integer.parseInt(br.readLine());
		int paperX; int paperY;
		int[][] board = new int[100][100];	//도화지의 크기는 100x100
		StringTokenizer st;
		
		for(int t=0; t<paperCount; t++) {
			st = new StringTokenizer(br.readLine());
			paperX = Integer.parseInt(st.nextToken());
			paperY = Integer.parseInt(st.nextToken());
			
			//색종이의 x,y좌표(왼쪽 아래)지점에서 시작해 넓이만큼 채움
			for(int i=paperX; i < paperX + 10; i++) {
				for(int j=paperY; j < paperY + 10; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		int area = 0;	
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(board[i][j] == 1) {
					area++;
				}
			}
		}
		
		bw.write(Integer.toString(area));
		bw.flush();
		bw.close();
	
		

	}

}
