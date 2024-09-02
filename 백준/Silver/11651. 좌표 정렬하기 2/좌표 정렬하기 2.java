import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair p) {
        if (this.y == p.y) {
            return this.x - p.x;
        }
        return this.y - p.y;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());    //N개의 입력값
        Pair[] pArr = new Pair[N];  //N 크기의 Pair타입 배열 생성
        int x; int y;
        for (int t = 0; t < N; t++) {
            //한줄씩 좌표를 입력받고 각 x, y값을 가지도록 Pair객체 생성해 배열 할당
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            pArr[t] = new Pair(x, y);
        }
        Pair temp = null;
        Arrays.sort(pArr);
        for (Pair p : pArr) {
            bw.write(Integer.toString(p.x));
            bw.write(" ");
            bw.write(Integer.toString(p.y));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
