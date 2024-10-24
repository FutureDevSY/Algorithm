import java.io.*;
import java.util.*;

public class Main
{
    static int cntOne = 0;
    static int cntZero= 0;
    static int[][] dp;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		dp = new int[2][41];
		dp[0][0] = 1;
		dp[1][1] = 1;

        for(int i=2; i<41; i++){
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }
		
		int N = 0;
		for(int t=0; t<T; t++){
		    N = Integer.parseInt(br.readLine());
		    
		    sb.append(dp[0][N]).append(" ").append(dp[1][N]).append('\n');
		  
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
}
