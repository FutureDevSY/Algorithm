public class Main {
	public static void main(String[] args) {
		// 셀프넘버를 넣을 배열 선언
		boolean check[] = new boolean[10001];

		// 1-10000까지 반복 -> 셀프넘버가 아닌 경우 배열에 true로 입력
		for (int i = 1; i < 10001; i++) {
			int n = Self(i);
			if(n<10001)
				check[n] = true;
		}
		
		// StringBuilder 선언
		StringBuilder sb = new StringBuilder();
		
		// 반복문을 사용 false인 경우 셀프넘버
		for(int i=1;i<10001;i++) {
			if(check[i]!=true)
				sb.append(i).append('\n');
		}
		
		// 결과 출력
		System.out.print(sb);
	}

	// 셀프넘버를 구하는 메소드 선언
	public static int Self(int n) {
		int total = n;
		while (n != 0) {
			total += (n % 10);
			n /= 10;
		}
		return total;
	}
}
