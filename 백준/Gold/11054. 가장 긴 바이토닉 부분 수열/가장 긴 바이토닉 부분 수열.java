import java.io.*;
import java.util.StringTokenizer;

public class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //수열의 크기 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());    //수열 입력받음
        int[] nums = new int[N];
        int ascResult = 0;    //전체를 오름차순으로 봤을때 가장 긴 부분수열 길이
        int desResult = 0;    //전체를 내림차순으로 봤을때 가장 긴 부분수열 길이
        int ascDesResult = 0; //오름차순->내림차순을 봤을때 가장 긴 부분수열 길이
        int maxResult = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ascDesResult = findLongestBitonic(nums);
        bw.write(Integer.toString(ascDesResult));
        bw.flush();
        bw.close();
    }

    public static int findLongestBitonic(int[] n){
        int pivot = 0;  //수열에서 가장 큰 수
        int ascLength = 0;  //pivot까지의 가장 긴 오름차순 부분수열
        int desLength = 0; //pivot까지의 가장 긴 내림차순 부분수열
        int totalLength = 0;    //최장 부분수열 총 길이 합
        int[] dp = new int[n.length];

        for (int p = 0; p < n.length; p++) {
            //n배열의 처음~pivot까지의 가장 긴 부분수열 길이 구하기(오름차순)
            ascLength = 0; desLength = 0;
            for (int i = 0; i <= p; i++) {  //i부터 pivots에 있는 pivot 인덱스까지
                dp[i] = 1;  //기본적으로 1이 들어간다(자기 자신 하나가 일단 원소니까 최소 길이는 모두 1씩)
                for (int j = 0; j < i; j++) {
                    if (n[j] < n[i] && dp[j] + 1 > dp[i]) {
                    /*증가하는 수열이 되어야 하니까 일단 j 원소의 크기가 i보다 작은지부터 확인,
                    dp[j]의 값, 즉 j번째 원소 다음에 i번째 원소가 오도록 수열을 만드는게 이득이면 dp[i] 갱신 */
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            ascLength = dp[p];  //처음부터 dp p번째 원소까지의 최장 부분수열

            //n배열의 끝~pivot까지의 가장 긴 부분수열 길이 구하기(내림차순)
            for (int i = n.length-1; i >= p; i--) {
                dp[i] = 1;  //기본적으로 1이 들어간다(자기 자신 하나가 일단 원소니까 최소 길이는 모두 1씩)
                for (int j = n.length-1; j > i; j--) {
                    if (n[j] < n[i] && dp[j] + 1 > dp[i]) {
                    /*증가하는 수열이 되어야 하니까 일단 j 원소의 크기가 i보다 작은지부터 확인,
                    dp[j]의 값, 즉 j번째 원소 다음에 i번째 원소가 오도록 수열을 만드는게 이득이면 dp[i] 갱신 */
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            desLength = dp[p];

            if (totalLength < ascLength + desLength - 1) {  //기존 totalLength보다 더 크다면 갱신
                totalLength = ascLength + desLength - 1;
            }
        }

        return totalLength;
    }
}
