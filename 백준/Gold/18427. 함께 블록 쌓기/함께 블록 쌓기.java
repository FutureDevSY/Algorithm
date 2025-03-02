import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, H;    //학생수, 최대블록수, 만들어야할 높이
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        List<Integer>[] studBlocks = new ArrayList[N];
        for(int i=0; i< studBlocks.length; i++){
            studBlocks[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                studBlocks[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(studBlocks[i]);
        }

        int[][] dp = new int[N + 1][H + 1];
        int tmp = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                for(int k=0; k<studBlocks[j-1].size(); k++){
                    tmp = studBlocks[j-1].get(k);
                    if(tmp == i) {
                        dp[j][i]++;
                        continue;
                    }
                    else if(tmp > i) break;
                    dp[j][i] += dp[j-1][i - tmp] % 10007;
                }
                dp[j][i] += dp[j-1][i] % 10007;
            }
        }

        System.out.println(dp[N][H] % 10007);



    }
}
