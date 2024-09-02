import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] splitByMinus = str.split("-");
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < splitByMinus.length; i++) {
            String[] splitByPlus = splitByMinus[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < splitByPlus.length; j++) {
                sum += Integer.parseInt(splitByPlus[j]);
            }
            if (result == Integer.MAX_VALUE) { //맨 첫번째 값이면 빼지말고 그냥 넣어준다
                result = sum;
            } else {
                result -= sum;
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
