
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            long[] liquids = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  liquids[i] = Integer.parseInt(st.nextToken());
            }

            long first = 0;    //첫번째로 선택한 용액의 값
            int startIdx, endIdx;
            long minV = Long.MAX_VALUE;
            long tmp;
            long[] results = new long[3];

            Arrays.sort(liquids);

            out : for (int i = 0; i < N; i++) {
                  first = liquids[i];
                  startIdx = i + 1;
                  endIdx = N - 1;

                  while(startIdx < endIdx){
                        tmp = liquids[startIdx] + liquids[endIdx] + first;
                        if(Math.abs(tmp) < minV){
                              results[0] = first;
                              results[1] = liquids[startIdx];
                              results[2] = liquids[endIdx];
                              minV = Math.abs(tmp);
                              if(tmp == 0) break out;
                        }

                        if(tmp < 0) startIdx++;
                        else endIdx--;
                  }
            }

            bw.write(results[0] + " " + results[1] + " " + results[2]);
            bw.flush();


      }

}
