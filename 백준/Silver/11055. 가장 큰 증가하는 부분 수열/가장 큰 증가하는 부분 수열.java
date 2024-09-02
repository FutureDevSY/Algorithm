import java.io.*;
import java.util.StringTokenizer;

public class Main {  //백준 11055번 가장 큰 증가 부분수열 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //수열의 크기 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());    //수열 입력받음
        int[] nums = new int[N];
        int[] dp = new int[N];  
        int max = 0;  
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i];  //기본적으로 자기 자신 값이 들어간다(자기 자신 하나가 일단 원소니까 기본적으로 넣어줌)
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + nums[i] > dp[i]) {
                    dp[i] = dp[j] + nums[i];    //dp[j] + dp[i] 로해서 값이 잘못나오고있었다
                }
            }
            if(max < dp[i]) max = dp[i];   
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
