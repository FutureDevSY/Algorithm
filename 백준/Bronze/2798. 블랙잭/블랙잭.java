import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;	//카드 개수
	static int M;
	static int[] cards;
	static int[] choice;
	static int max, sum;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    cards = new int[N];
	    choice = new int[3];
	    max = sum = 0;
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++) {
	    	cards[i] = Integer.parseInt(st.nextToken());
	    }
	    comb(0, 0);
	    bw.write(Integer.toString(max));
	    bw.close();
	    
	}
	//조합
	public static void comb(int idx, int start) {
		if(idx >= 3) {
			sum = 0;
			for(int i : choice) {
				sum += cards[i];
				if(sum > M) return;
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start; i<N; i++) {
			choice[idx] = i;
			comb(idx + 1, i + 1);
		}
	}
	
	
}
