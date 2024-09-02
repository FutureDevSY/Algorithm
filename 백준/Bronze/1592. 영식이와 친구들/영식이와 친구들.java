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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//1~N명의 사람들
		int M = Integer.parseInt(st.nextToken());	//누군가가 M번 받으면 게임끝
		int L = Integer.parseInt(st.nextToken());	//특정방향으로 L번째 사람에게 던짐
		int[] ballCounts = new int[N];	//각 인원이 공을 받은 횟수
		
		int turn = 0;
		int throwCount = 0;	//공을 던진!횟수
		
		//받는것과 던지는것 착각하면 안됨!!!
		while(true) {	//현재차례의 사람이 공을 M번받을때까지	
			ballCounts[turn]++;
			if(ballCounts[turn]== M) break;
			//공 던져서 받을사람 결정 
			if(ballCounts[turn] % 2 == 0) {	//짝수번 받았다면 반시계방향, 거꾸로
				turn = turn - L;
				if(turn < 0) {
					turn = turn + N;
				}
			}
			else {	//홀수번 받았다면 시계방향, 오름차순
				turn = turn + L;
				if(turn >= N) {
					turn = turn - N;
				}
			}
			//다음 차례가 정해졌으므로 던진횟수 증가
			throwCount++;
			
		}
		bw.write(Integer.toString(throwCount));
		bw.flush();
		bw.close();
	}

}
