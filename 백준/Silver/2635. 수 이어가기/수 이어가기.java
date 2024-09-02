import java.io.*;
import java.util.ArrayList;

public class Main {  //수 이어가기 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //첫번째로 주어질 수
        ArrayList<Integer> al = new ArrayList<>(N);
        ArrayList<Integer> maxAl = new ArrayList<>(N);  //최대 길이가 되는 값들을 저장할 리스트
        int pre;    //연산할때 앞에있는 수
        int next;   //연산할때 뒤에있는 수
        int max = 0;    //최대길이값
        int temp = 0;
        int tmp;
        for (int i = 0; i <= N; i++) {   //여기서 <N이라고 한게 문제였다. N을 포함해야함
            al.clear();
            al.add(N);
            al.add(i);
            pre = N;
            next = i;
            while (pre - next >= 0) { //다음에 오는 수가 음수가 되면 끝
                al.add(pre - next);
                tmp = next;
                next = pre - next;
                pre = tmp;
            }
            if (al.size() > max) {  //리스트 크기가 Max값보다 크다면(더 길다면)
                maxAl.clear();  //비워주자
                max = al.size();
                while (!al.isEmpty()) {     //이거보다 더 좋은 옮기는 방법 없을까??
                    maxAl.add(al.remove(0));
                }
            }

        }
        temp = 0;
        bw.write(Integer.toString(max));
        bw.newLine();
        while (!maxAl.isEmpty()) {
            bw.write(maxAl.remove(0) + " ");
        }
        bw.flush();
        bw.close();
    }
}
