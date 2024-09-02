import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		//입력을 빠르게 받기 위해 bufferedReader 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//출력을 빠르게 내보내기 위해 bufferedWriter 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		//테스트 횟수 한줄 입력받고 정수형으로 변환
//		int T = Integer.parseInt(br.readLine());
		
		//테스트케이스 개수만큼 반복
//		for(int t=1; t<= T; t++) {
			//stringtokenizer로 한줄 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력받은 한줄에서 공백 기준으로 끊어진 토큰 하나가 컵의 개수 
			int cups = Integer.parseInt(st.nextToken());
			//입력받은 한줄에서 공백 기준으로 끊어진 다음 토큰 하나가 간식의 위치 
			int idx = Integer.parseInt(st.nextToken()) - 1;
			//컵 위치를 교환할 횟수
			int change = Integer.parseInt(st.nextToken());
			
			//종이컵 정보 담을 배열
			int[] cupArr = new int[cups];
			//간식 위치에 값 1 할당
			cupArr[idx] = 1;
			
			//교환하기 위한 변수 세개 선언
			int tmp, tmp1, tmp2;
			//교환 횟수만큼 반복 
			for(int i=0; i<change; i++) {
				//stringtokenizer로 한줄 입력받기
				st = new StringTokenizer(br.readLine());
				//tmp1에 교환할 위치 하나 저장
				tmp1 = Integer.parseInt(st.nextToken()) - 1;
				//tmp2에 교환할 위치 하나 저장
				tmp2 = Integer.parseInt(st.nextToken()) - 1;
				
				//임시 TMP변수에 교환위치에 있는 값 하나 저장해둠
				tmp = cupArr[tmp1];
				//tmp1에 tmp2값을 저장
				cupArr[tmp1] = cupArr[tmp2];
				//tmp2에 원래 tmp1값 저장 
				cupArr[tmp2] = tmp;
				
			}
			//배열을 돌 반복문 
			for(int i=0; i<cups; i++) {
				//배열을 돌다가 간식이위치한 (1이 들어있는)곳이 나오면 
				if(cupArr[i] != 0) {
					//해당 인덱스 출력 
					bw.write(Integer.toString(i+1));
				
				}
			}
			
//		}
		//버퍼스트림 닫기
		bw.close();
		
		
		
		
	}
}
