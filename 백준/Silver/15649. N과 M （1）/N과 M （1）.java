import java.io.*;
import java.util.StringTokenizer;

public class Main {  //백준 15649번 N과 M 문제
    static int[] nums;
    static boolean[] isUsed;
    static int count = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //1~N까지의 자연수
        int M = Integer.parseInt(st.nextToken());   //중복없이 M개 고르기
        nums = new int[8];  //N은 최대 8
        isUsed = new boolean[9];
        printSeries(N,M,count);
        bw.flush();
        bw.close();
    }
    static void printSeries(int N, int M, int count) throws IOException {  //조건 만족하는 모든 수열들을 출력
        for (int i = 1; i <= N; i++) {
            if (count == M) {   //M만큼 다 채웠으면 출력한다
                for (int j = 0; j < M; j++) {
                    bw.write(Integer.toString(nums[j]) + " ");
                }
                bw.newLine();
                return;
            } else if (!isUsed[i]) {   //사용안한 숫자라면
                nums[count] = i;  //count번에 i 할당
                isUsed[i] = true;   //사용했다 찜함
                count++;
                printSeries(N,M,count);
                isUsed[i] = false;
                count--;
            }

        }
    }
}
