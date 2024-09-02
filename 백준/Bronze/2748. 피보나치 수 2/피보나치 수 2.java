import java.io.*;

public class Main {
    static int N;
    static long[] memorize;
    static long i1 = 0L;
    static long i2 = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        memorize = new long[N + 1];
        bw.write(recurFibo(N) + "");
        bw.close();
    }
    static long recurFibo(int N){
        if(N == 0 || N == 1){
            //재귀 종료조건
            return N;
        }   //N-1번째의 피보나치값 + N-2번째 피보나치값의 합이 N의 피보나치값이되는것 이용
        if(memorize[N-1] != 0){
            i1 = memorize[N-1];
        }else{  //저장이 안되어있을때만 재귀호출
            i1 = recurFibo(N-1);
        }
        if(memorize[N-2] != 0){
            i2 = memorize[N-2];
        }else{  //저장이 안되어있을때만 재귀호출
            i2 = recurFibo(N-2);
        }
        memorize[N] = i1 + i2;
        return memorize[N];
    }
}
