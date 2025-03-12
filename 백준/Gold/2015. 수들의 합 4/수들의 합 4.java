import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K; //원소개수, 만들어야할 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sumArr = new long[N];
        HashMap<Long, Long> map = new HashMap<>();

        long cntK = 0;
        for (int i = 0; i < N; i++) {
            if(i == 0) sumArr[i] = Integer.parseInt(st.nextToken());
            else sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i - 1];

            if(map.containsKey(sumArr[i] - K)){
                cntK += map.get(sumArr[i] - K);
            }
            if(sumArr[i] == K) cntK++;

            //나중에 저장해야함
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0L) + 1);
        }

        System.out.println(cntK);
    }
}
