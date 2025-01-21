import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 사탕개수
            int W = Integer.parseInt(st.nextToken()); //무게제한

            ArrayList<Integer> threeCandy = new ArrayList<>();
            ArrayList<Integer> fiveCandy = new ArrayList<>();

            int a, b;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());
                  if(a == 3) threeCandy.add(b);
                  else fiveCandy.add(b);
            }
            Collections.sort(threeCandy, Collections.reverseOrder());
            Collections.sort(fiveCandy, Collections.reverseOrder());

            long[] threeArr = new long[threeCandy.size() + 1];
            long[] fiveArr = new long[fiveCandy.size() + 1];
            for (int i = 1; i < threeArr.length; i++) {
                  threeArr[i] = threeCandy.get(i - 1) + threeArr[i - 1];
            }
            for (int i = 1; i < fiveArr.length; i++) {
                  fiveArr[i] = fiveCandy.get(i - 1) + fiveArr[i - 1];
            }

            int maxThreeCnt = Math.min(W / 3, threeCandy.size()); //3짜리 사탕이 최대 몇개들어가는지

            int leftWeight = 0; //3짜리 사탕을 빼고 남는공간
            int canAddFive = 0; //5짜리 사탕이 몇개 더 들갈수있는지
            long maxSweet = 0;
            long sum = 0;
            for (int i = maxThreeCnt; i >= 0; i--) {
                  leftWeight = W - (i * 3);
                  canAddFive = Math.min(leftWeight / 5, fiveCandy.size());
                  sum = fiveArr[canAddFive] + threeArr[i];
                  maxSweet = Math.max(maxSweet, sum);
            }

            System.out.println(maxSweet);

      }
}
