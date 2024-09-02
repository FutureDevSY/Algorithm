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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//과일 개수
		int L = Integer.parseInt(st.nextToken());	//초기길이
		int[] fruitsH = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			fruitsH[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruitsH);  //오름차순 정렬
		
		for(int i=0; i<N; i++) {
			if(L < fruitsH[i]) break;
			
			if(fruitsH[i] <= L) {	//길이보다 과일 높이가 같거나 작다면 먹을수있음
				L++;	//길이 1 증가
			}
		}
		
		bw.write(Integer.toString(L));
		bw.close();

	}
}
