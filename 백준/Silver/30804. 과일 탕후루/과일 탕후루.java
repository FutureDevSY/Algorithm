import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] intArr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                  intArr[i] = Integer.parseInt(st.nextToken());
            }

            if(N < 2){
                  System.out.println(N);
            }else{
                  map.put(intArr[0], 1);
                  map.put(intArr[1], 1);
                  int s = 0;
                  int e = 1;

                  int maxLng = 2;
                  while (e < N - 1) {
                        e++;
                        map.put(intArr[e], map.getOrDefault(intArr[e], 0) + 1);
                        while(map.size() > 2){
                              if(map.containsKey(intArr[s])){
                                    map.put(intArr[s], map.get(intArr[s]) - 1);
                              }
                              if(map.containsKey(intArr[s]) && map.get(intArr[s]) == 0) map.remove(intArr[s]);
                              s++;
                        }
                        maxLng = Math.max(maxLng, e - s + 1);
                  }
                  System.out.println(maxLng);
            }



      }

}
