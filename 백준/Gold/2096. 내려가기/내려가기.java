import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] scores = new int[N][3];
            int[][] dpMax = new int[N][3];
            int[][] dpMin = new int[N][3];
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  scores[i][0] = Integer.parseInt(st.nextToken());
                  scores[i][1] = Integer.parseInt(st.nextToken());
                  scores[i][2] = Integer.parseInt(st.nextToken());
            }
            dpMax[0][0] = scores[0][0];
            dpMax[0][1] = scores[0][1];
            dpMax[0][2] = scores[0][2];

            dpMin[0][0] = scores[0][0];
            dpMin[0][1] = scores[0][1];
            dpMin[0][2] = scores[0][2];

            for (int i = 1; i < N; i++) {
                  dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + scores[i][0];
                  dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]) + scores[i][1];
                  dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + scores[i][2];

                  dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + scores[i][0];
                  dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]) + scores[i][1];
                  dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + scores[i][2];
            }
            int maxResult = Math.max(Math.max(dpMax[N - 1][0], dpMax[N - 1][1]), dpMax[N - 1][2]);
            int minResult = Math.min(Math.min(dpMin[N - 1][0], dpMin[N - 1][1]), dpMin[N - 1][2]);
            System.out.println(maxResult + " " + minResult);
      }

}
