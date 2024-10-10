import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            HashMap<String, Integer> map = new HashMap<>();
            String treeName;
            int totalCnt = 0;
            while ((treeName = br.readLine()) != null && !treeName.isEmpty()) {
                  totalCnt++;
                  map.put(treeName, map.getOrDefault(treeName, 0) + 1);
            }

            Object[] keyList = map.keySet().toArray();
            Arrays.sort(keyList);
            for (Object str : keyList) {
                  System.out.print(str + " ");
                  System.out.println(String.format("%.4f", (double)map.get(str) / totalCnt * 100));
            }

      }

}
