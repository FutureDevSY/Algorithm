import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            int toFind = 0;
            int start = 1;
            int end = N - 1;
            int good = 0;
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                  toFind = nums[i];
                  if(i == start) start++;
                  else if(i == end) end--;

                  while (start < end) {
                        tmp = nums[start] + nums[end];
                        if (tmp == toFind) {
                              good++;
                              break;
                        }else{
                              if(tmp < toFind){
                                    start = (start + 1 == i) ? start + 2 : start + 1;
                              } else if (tmp > toFind) {
                                    end = (end - 1 == i) ? end - 2 : end - 1;
                              }
                        }
                  }
                  start = 0;
                  end = N - 1;
            }

            System.out.println(good);

      }
}
