import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {     //백준 숫자카드 2 문제
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //카드개수
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int M = Integer.parseInt(br.readLine());    //찾아야 할 수의 개수
//        int[] Mnums = new int[M];
        st = new StringTokenizer(br.readLine());
        int toFind = 0;
        int lb; int ub; //하한선, 상한선
        for (int i = 0; i < M; i++) {
            toFind = Integer.parseInt(st.nextToken());
            lb = LowerBound(0, cards.length, toFind);
            ub = UpperBound(0, cards.length, toFind);   //ub는 인덱스를 -1해서보면 안된다 왜인지는 잘 생각해보길...

            bw.write(ub - lb + " ");
        }

        bw.flush();
        bw.close();
    }

    static int LowerBound(int l, int h, int x) {    //하한선, x보다 같거나 큰 수들 중 가장 작은 수 (처음 나타나는 x 이상의 수)
        int mid = 0;
        while (l < h) {
            mid = (l + h) / 2;
            if (cards[mid] == x) {
                h = mid;
            } else if (cards[mid] < x) {
                l = mid + 1;    //찾고자하는 값이 mid 이하로는 없을 것이므로 범위 줄인다
            } else {    //찾고자하는 값이 mid값보다 작다면
                h = mid;
            }
        }
        return l;
    }

    static int UpperBound(int l, int h, int x) {    //상한선, x보다 큰 수들 중 가장 작은 수 (처음 나타나는 x 초과 수)
        int mid = 0;
        while (l < h) {
            mid = (l + h) / 2;
            if (cards[mid] == x) {
                l = mid + 1;
            } else if (cards[mid] < x) {
                l = mid + 1;    //찾고자하는 값이 mid 이하로는 없을 것이므로 범위 줄인다
            } else {    //찾고자하는 값이 mid값보다 작다면
                h = mid;
            }
        }
        return l;
    }

}
