import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            double doubleB;
            int cnt = 0;
            while(B > A){
                  doubleB = (double)B / 2;
                  if(doubleB == B / 2) B = B / 2;
                  else if(B % 10 == 1) B = B / 10;
                  else break;
                  cnt++;
            }
            if(B != A) System.out.println(-1);
            else System.out.println(cnt + 1);
      }

}
