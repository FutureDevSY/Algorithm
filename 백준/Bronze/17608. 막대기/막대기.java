import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = Integer.parseInt(br.readLine());
        }
        int height;
        int count = 1;  //일단 첫번째 막대는 무조건 보이니까
        int x = sticks[sticks.length-1];

        for (int i = N-2; i >= 0; i--) {
            if (x < sticks[i]) {
                count++;
                x = sticks[i];
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
       

    }
}
