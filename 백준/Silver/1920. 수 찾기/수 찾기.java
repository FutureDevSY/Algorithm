import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //N개의 수들중 M이 존재하는지
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);  //이분검색 전에 정렬 꼭!!
        int M = Integer.parseInt(br.readLine());
        int[] ms = new int[M];  //M들이 nums에 존재하는지
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ms[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(Integer.toString(binarySearch(0, nums.length-1, ms[i])));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int binarySearch(int left, int right, int m) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (m == nums[mid]) {
                return 1;
            }
            if (m > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
