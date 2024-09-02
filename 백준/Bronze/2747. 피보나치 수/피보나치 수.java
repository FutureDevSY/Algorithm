import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] memorize;
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        memorize = new int[N + 1];
        bw.write(Integer.toString(recurFibo(N)));
        bw.close();
    }
    static int recurFibo(int N){
        if(N == 0 || N == 1){
            //재귀 종료조건
            return N;
        }   //N-1번째의 피보나치값 + N-2번째 피보나치값의 합이 N의 피보나치값이되는것 이용
        int i1; int i2;
        if(N-1 >= 0 && N-1 < N  && memorize[N-1] != 0){
            i1 = memorize[N-1];
        }else{
            i1 = recurFibo(N-1);
        }
        if(N-2 >= 0 && N-2 < N  && memorize[N-2] != 0){
            i2 = memorize[N-2];
        }else{
            i2 = recurFibo(N-2);
        }
        temp = i1 + i2;
        memorize[N] = temp;
        return temp;
    }
}
