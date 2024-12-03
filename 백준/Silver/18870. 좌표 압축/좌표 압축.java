import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            int[] intArr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                  intArr[i] = Integer.parseInt(st.nextToken());
                  list.add(intArr[i]);
            }
            Collections.sort(list);
            HashMap<Integer, Integer> map = new HashMap<>();
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                  if(i != 0){
                        if(!Objects.equals(list.get(i - 1), list.get(i))) tmp++;
                  }
                  map.put(list.get(i), tmp);
            }

            for (int i = 0; i < N; i++) {
                  bw.write(map.get(intArr[i]) + " ");
            }
            bw.close();

      }

}
