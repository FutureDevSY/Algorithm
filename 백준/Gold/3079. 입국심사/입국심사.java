import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;   //입국심사대, 사람수
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] Ntime = new long[N]; //입국심사대별로 걸리는 시간
        long right = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            Ntime[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, Ntime[i]);
        }

        Arrays.sort(Ntime);

        long left = 1;
        right *= M;   //가장 오래 걸리는 시간은 사람수 * 가장 오래걸리는 입국심사대 시간
        if(N == 1 || M == 1){
            //입국심사대가 하나거나 사람이 한명뿐일때
            System.out.println(M * Ntime[0]);
        }else{
            long mid;
            long cntPpl = 0;
            long minTime = Long.MAX_VALUE;
            while(left < right){
                mid = (left + right) / 2;
                cntPpl = 0;
                for (int i = 0; i < N; i++) {
                    cntPpl += mid / Ntime[i];
                    if(cntPpl >= M) break;
                }
                if(cntPpl >= M){
                    minTime = Math.min(minTime, mid);
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

            System.out.println(minTime);
        }

    }
}
