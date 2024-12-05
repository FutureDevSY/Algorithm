import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      static int N, M;     //도시의 개수, 버스의 개수
      static int[][] dist;
      static int INF = 100000000;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            dist = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        if(i == j) dist[i][j] = 0;
                        else dist[i][j] = INF;
                  }
            }
            int a, b, c;
            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());
                  c = Integer.parseInt(st.nextToken());
                  dist[a][b] = Math.min(dist[a][b], c);
            }

            fluid();

            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        if(dist[i][j] == INF) bw.write("0" + " ");
                        else bw.write(Integer.toString(dist[i][j]) + " ");
                  }
                  bw.write('\n');
            }

            bw.close();

      }

      static void fluid(){
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        for (int k = 1; k <= N; k++) {
                              if(dist[j][k] > dist[j][i] + dist[i][k]){
                                    dist[j][k] = dist[j][i] + dist[i][k];
                              }
                        }
                  }
            }
      }

}
