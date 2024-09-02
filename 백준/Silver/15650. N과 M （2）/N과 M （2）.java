import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      static int N, M;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] arr = new int[M];
            comb(0, 0, arr, 1);

      }

      static int sumCnt;
      static void comb(int idx, int depth, int[] arr, int start){
            if(depth == M) {
                  sumCnt++;
                  printArr(arr);
                  return;
            }

            if(idx >= M || start > N) return;

            // 해당 위치 원소를 뽑은경우
            arr[idx] = start;
            comb(idx + 1, depth + 1, arr, start + 1);
            // 뽑지 않을경우
            comb(idx, depth, arr, start + 1);

      }

      static void printArr(int[] arr){
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
      }
}
