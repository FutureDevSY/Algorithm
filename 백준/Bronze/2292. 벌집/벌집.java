import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sixMulti = 0;   //1부터 시작, 6의 배수로 증가
        int count = 0;

        N = N - 1;  // 1에서 6이 되는것만 예외이므로 이건 따로 빼서 계산되도록 했다
        while (N > 0) {
            count++;    //빼봤더니 1 이상이라면 카운트
            sixMulti += 6;  //다음으로 빼게 될 수 갱신
            N = N - sixMulti;
        }
        count++;    //+1해주어야 원하는 결과가 나온다..

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
