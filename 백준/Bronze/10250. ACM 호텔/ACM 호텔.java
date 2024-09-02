import java.io.*;
import java.util.StringTokenizer;

public class Main {     //백준 10250번 호텔문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int H;  //층수
        int W;  //방 수
        int N;  //손님순서
        int room;   //손님에게 배정될 방 호수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int roomHeight; int roomNum;
            if (N < H) {    //H보다 N이 작을경우엔 나머지값 그대로가 층수가 되고 거리는 1이 된다
                roomHeight = N % H;
                roomNum = 1;
            }else if (N % H == 0) {   //나머지값이 0이면 몫이 그대로 거리가 된다
                roomNum = N / H;
                roomHeight = H;     //층수는 최고층수가 된다
            } else {    //나머지가 1 이상이라면 다음줄로 건너가야해서 +1해주는것, 나머지값은 그래도 높이가 된다
                roomNum = (N / H) + 1;
                roomHeight = N % H;
            }

            bw.write(Integer.toString(roomHeight));
            if (roomNum < 10) {
                bw.write("0");  //거리가 한자리 수라면 앞에 0 붙여야함
            }
            bw.write(Integer.toString(roomNum));
            bw.newLine();

        }
        bw.flush();
        bw.close();


    }
}
