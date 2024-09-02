import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		//입력되는 수열의 크기가 최대 10000인데 시간제한이 0.5초고 실버문제라서 시간 감축하는방법 생각해야할듯
		//뭔가 dp로 풀수 있을지도..?
		//바로 뒤에 오는 수가 M-현재수 보다 크면 유망하지 않음, 바로 넘어감
		//바로 뒤에 오는 수가 M-현재수보다 작거나 같으면 유망함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;	//수열의 길이(원소개수)
		int M;	//부분수열의 합이 M이 되는 경우의수 구하면됨
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] intArr = new int[N];
		st = new StringTokenizer(br.readLine());
		//입력받은 수열 정보 배열 저장
		for(int i=0; i<N; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp = 0;
		int count = 0;	//합쳐서 M이 되는 경우의수
		int rest = 0;
		
		for(int i=0; i<N; i++) {
			temp = 0; rest = 0;
			temp += intArr[i];
			if(temp == M) {	//만약 첫 선택한(시작점)인덱스의 원소가 M이라면 바로 카운트하고 건너뛴다
				count++;
				continue;
			}
			if(i == N-1) break;	//맨 마지막 원소면서 위에 if문에 안걸렸다면 바로 빠져나감
			
			for(int j=i+1; j<N; j++) {
				rest = M - temp;
				if(rest < intArr[j]) {	//다음에 더할 값이 M에서 현재까지 누적된 수를 뺀 값보다 더 크다면 유망하지않다
					break;	//더 볼필요도 없음
				}else if(rest == intArr[j]) {
					count++;
					break;	//M만드는데 성공, 빠져나감
				} else {
					temp += intArr[j];	//일단 더 지켜봄
				}
			}
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();

	}

}
