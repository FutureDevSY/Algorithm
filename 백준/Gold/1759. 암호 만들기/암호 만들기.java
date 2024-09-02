import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int L, C; //암호 길이, 주어진 문자 수
    static List<String> li = new ArrayList<>();
    static char[] selected, alpList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        selected = new char[L];
        alpList = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            alpList[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpList);
        select(0,0);
        for (String str : li) {
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void select(int cnt, int start) {    //순열
        if (cnt >= L) {
            int cCnt = 0;    //자음개수
            int vCnt = 0;    //모음개수
            for (int i = 0; i < L; i++) {
                if (selected[i] == 'a'
                        || selected[i] == 'e'
                        || selected[i] == 'i'
                        || selected[i] == 'o'
                        || selected[i] == 'u') {
                    cCnt++;
                } else vCnt++;
            }
            if (cCnt < 1 || vCnt < 2) return;

            li.add(new String(selected));
            return;
        }

        for (int i = start; i < C; i++) {
            selected[cnt] = alpList[i];
            select(cnt + 1, i+1);
        }
    }
}
