import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int lng = (int)Math.pow(2, N);
            int start = 0;
            int r = 0;
            int c = 0;

            while(lng > 1){
                  lng = lng / 2;

                  if(R < r + lng && C < c + lng){
                        continue;
                  }else if(R < r + lng && C >= c + lng){
                        c = c + lng;
                        start = start + (lng * lng);
                        continue;
                  }else if(R >= r + lng && C < c + lng){
                        r = r + lng;
                        start = start + (lng * lng * 2);
                        continue;
                  }else if(R >= r + lng && C >= c + lng){
                        r = r + lng;
                        c = c + lng;
                        start = start + (lng * lng * 3);
                        continue;
                  }
            }
            System.out.println(start);
      }

}
