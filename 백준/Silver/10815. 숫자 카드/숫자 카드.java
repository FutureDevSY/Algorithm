import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {   //백준 10815번 숫자카드 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());    //가지고있는 수 카드 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());    //있는지 없는지 알아볼 수의 개수
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        //이진탐색
        int key; int mid; int low; int high;
        for (int i = 0; i < M; i++) {
            low = 0; high = cards.length-1;
            key = nums[i];
            while(low <= high) {
                mid = (low + high) / 2;
                if(key == cards[mid]) {
                    bw.write(Integer.toString(1) + " ");  //발견
                    break;
                } else if(key < cards[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (low > high) {
                bw.write(Integer.toString(0) + " ");  //뒤져봤지만 결국없음
            }
        }
        bw.flush();
        bw.close();

    }
}
