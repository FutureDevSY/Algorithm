import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int origin = Integer.parseInt(br.readLine());
        int a; int b;
        int temp = origin;
        int abTmp = 0;    //a와 b를 합친 수에서 1의자리수
        int cycle = 0;  //몇번만에 origin 수까지 되돌아오는지
        while (temp != origin || cycle == 0) {
            a = temp / 10;  //10의자리수 (temp가 한자리수면 0이들어갈것)
            b = temp % 10;  //1의자리수
            abTmp = (a + b) % 10;
            temp = (b * 10) + abTmp;
            cycle++;
        }
        bw.write(Integer.toString(cycle));
        bw.flush();
        bw.close();
    }
}
