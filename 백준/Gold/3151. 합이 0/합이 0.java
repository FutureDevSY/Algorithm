import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] stuLevel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //학생수
        stuLevel = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            stuLevel[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stuLevel);

        int tmpSum;
        long cnt = 0;
        int left, right, mid;
        int upperIdx, lowerIdx;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                tmpSum = stuLevel[i] + stuLevel[j];

                if(tmpSum > 10000 || tmpSum < -10000) continue;
                //이분탐색
                left = j + 1;
                right = N;

                upperIdx = upperbound(left, right, -tmpSum);
                lowerIdx = lowerbound(left, right, -tmpSum);
                cnt += upperIdx - lowerIdx;
            }
        }

        System.out.println(cnt);


    }

    static int upperbound(int left, int right, int target){
        int mid;
        while(left < right){
            mid = (left + right) / 2;

            if(stuLevel[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    static int lowerbound(int left, int right, int target){
        int mid;
        while(left < right){
            mid = (left + right) / 2;

            if(stuLevel[mid] < target){
                left = mid + 1;
            }else{
                right = mid; //이게 헷갈림
            }
        }
        return right;
    }
}
