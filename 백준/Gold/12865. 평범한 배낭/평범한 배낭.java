
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//2차원 배열부터
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//물품의 수
		int K = sc.nextInt();	//최대무게
		int[][] D = new int[N+1][K+1];
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		int result = 0;
		
		for(int i=1; i<=N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(W[i] > j) {
					//어차피 내가 무게 안돼서 못들어가니까 이전값 그대로
					D[i][j] = D[i-1][j];
				}else {
					D[i][j] = Math.max(D[i-1][j], V[i] + D[i-1][j-W[i]]);
				}
				result = Math.max(result, D[i][j]);
			}
		}
//		System.out.println(D[N][K]);
		System.out.println(result);
		
	}
	
	
	
	
}
