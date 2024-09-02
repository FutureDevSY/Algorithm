import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int sum = A * B * C;
        String str = Integer.toString(sum);
        char[] chrArr = str.toCharArray();
        int[] count = new int[10];
        int temp;
        for (int i = 0; i < chrArr.length; i++) {
            temp = chrArr[i] - '0';
            count[temp]++;
        }
        for (int i = 0; i < count.length; i++) {
            bw.write(Integer.toString(count[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
