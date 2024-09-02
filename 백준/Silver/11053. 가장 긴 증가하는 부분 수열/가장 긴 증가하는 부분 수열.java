import java.io.*;
import java.util.StringTokenizer;

public class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //수열의 크기 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());    //수열 입력받음
        int[] nums = new int[N];
        int[] dp = new int[N];  //N크기만큼의 Dp배열 생성, 여기에 각 수열값들 위치까지의 최대 부분수열 길이가 들어갈것임
        int max = 0;    //가장 긴 부분수열 길이
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  //기본적으로 1이 들어간다(자기 자신 하나가 일단 원소니까 최소 길이는 모두 1씩)
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    /*증가하는 수열이 되어야 하니까 일단 j 원소의 크기가 i보다 작은지부터 확인,
                    dp[j]의 값, 즉 j번째 원소 다음에 i번째 원소가 오도록 수열을 만드는게 이득이면 dp[i] 갱신 */
                    dp[i] = dp[j] + 1;
                    
                }
            }
            if(max < dp[i]) max = dp[i];
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
