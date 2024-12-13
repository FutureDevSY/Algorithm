import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

      static int A, B, C; //  자연수 a를 b번 곱한 수, c로 나눈 나머지 구함
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            bw.write(Long.toString(divide(A, B, C)));
            bw.flush();
            bw.close();
      }

      public static long divide(long a, long b, long c){
            long half = 0;
            if(b == 0) return 1;
            else{
                  half = divide(a, b / 2, c);
                  if(b % 2 != 0){
                        return (half * half % c) * a % c;
                  }else{
                        return (half * half) % c;
                  }
            }
      }

}
