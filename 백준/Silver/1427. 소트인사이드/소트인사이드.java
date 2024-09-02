import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Main {  //백준 소트인사이드 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] arr;
        arr = str.toCharArray();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            bw.write(arr[i]);
        }
        bw.flush();
        bw.close();
    }
}
