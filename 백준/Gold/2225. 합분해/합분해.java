import java.io.*;
import java.util.StringTokenizer;

public class Main {   //백준 2225번 합분해 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //0~N까지의 정수 이용, 합이 N이 되도록
        int K = Integer.parseInt(st.nextToken());   //k개의 정수를 이용하여 N을 구한다

        int[][] dp = new int[K][N+1]; //KxN+1 크기의 2차원 배열을 만든다(N은 0부터 시작이므로 +1한 크기로 한다)

        for (int k = 1; k <= K; k++) {  //1~k까지(실제 배열의 인덱스는 0부터 시작이므로 k-1라고 매번 해줬다)
            for (int n = 0; n <= N; n++) {  //n은 0~n까지
                if(k == 1) dp[0][n] = 1;
                else if(n==0) dp[k-1][n] = 1;
                /*맨 첫줄은 다 1이 들어간다.k가 한개라면 N이 뭐든간에 한가지 경우밖에 없으니까
                 여기서 시작해 나머지들도 구할수있음
                 N이 0인 경우 또한 K가 뭐든간에 한가지 경우뿐이다
                 */
                else{
                    dp[k-1][n] = dp[k-1][n - 1] + dp[k - 2][n]; //왼쪽에 있는 dp값 + 위에 있는 dp값
                    dp[k-1][n] %= 1000000000;    //미리 여기서 나머지 연산을 해준다
                }
            }
        }

        bw.write(Integer.toString(dp[K-1][N]));    //나머지 출력
        bw.flush();
        bw.close();
    }
}
