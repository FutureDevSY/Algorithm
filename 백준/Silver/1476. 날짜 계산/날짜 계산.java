import java.io.*;
import java.util.StringTokenizer;

public class Main {    //백준 1476번 날짜 계산 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());   //1~15
        int S = Integer.parseInt(st.nextToken());   //1~28
        int M = Integer.parseInt(st.nextToken());   //1~19

        int e = 0; int s = 0; int m = 0;
        int year = 0;
        while (e != E || s != S || m != M) {
            year++;
            if (e == 15) e = 1;
            else e++;
            if (s == 28) s = 1;
            else s++;
            if (m == 19) m = 1;
            else m++;
        }

        bw.write(Integer.toString(year));
        bw.flush();
        bw.close();
    }
}
