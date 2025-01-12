import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                  int[][] input = new int[11][11];
                  StringTokenizer st;
                  for (int i = 0; i < 11; i++) {
                        st = new StringTokenizer(br.readLine());
                        for (int j = 0; j < 11; j++) {
                              input[i][j] = Integer.parseInt(st.nextToken());
                        }
                  }
                  boolean[] checked = new boolean[11]; //포지션이 정해졌는지
                  int sum = 0;
                  int count = 0;
                  max = Integer.MIN_VALUE;
                  dfs(input, checked, sum, count);

                  bw.write(Integer.toString(max) + '\n');
            }
            bw.close();

      }

      static int max = Integer.MIN_VALUE;
      static void dfs(int[][] input, boolean[] checked, int sum, int count){
            if(count == 11){
                  max = Math.max(max, sum);
                  return;
            }

            for (int i = 0; i < 11; i++) {
                  if(!checked[i] && input[i][count] != 0){
                        checked[i] = true;
                        dfs(input, checked, sum + input[i][count], count + 1);
                        checked[i] = false;
                  }
            }
      }
}
