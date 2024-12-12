import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //나무의 수
            M = Integer.parseInt(st.nextToken()); //가져갈 나무의 길이
            int[] heights = new int[N];
            st = new StringTokenizer(br.readLine());
            int maxHeight = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                  heights[i] = Integer.parseInt(st.nextToken());
                  maxHeight = Math.max(maxHeight, heights[i]);
            }

            long left = 1;
            long right = maxHeight;
            long mid = 0;
            while(left <= right){
                  mid = ((long)left + (long)right) / 2;
                  if(isEnoughHeight(mid, heights, M)){
                        left = mid + 1;
                  }else{
                        right = mid - 1;
                  }
            }

            System.out.println(right);
      }

      public static boolean isEnoughHeight(Long height, int[] heights, int M){
            long sum = 0;
            long tmp = 0;
            for (int i = 0; i < heights.length; i++) {
                  tmp = heights[i] - height;
                  if(tmp > 0) {
                        sum += tmp;
                  }
            }
            if(sum >= M) return true;
            else return false;
      }

}
