import java.util.Scanner;

public class Main {

	static int N, col[], ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];	//1열부터 사용
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}
	
	private static void setQueen(int row) {
		//가지치기
		if(!isAvailable(row-1)) return;
		
		//기저조건
		if(row>N) {
			ans++;
			return;
		}
		
		
		//유도파트
		for(int c = 1; c <= N; c++) {
			col[row] = c;
			setQueen(row + 1);
		}
	}
	
	//유망체크
	private static boolean isAvailable(int row) {
		for(int i=1; i<row; i++) {
			//같은 열에 있는지 , 대각선상에 있는지 체크
			if(col[i] == col[row] || row-i == Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		return true;
	}
}
