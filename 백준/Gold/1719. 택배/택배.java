import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N, M;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 집하장 개수
            M = Integer.parseInt(st.nextToken()); // 경로 개수
            int[][] dist = new int[N + 1][N + 1];
            int[][] before = new int[N + 1][N + 1];   //최단경로로 x까지 오기 직전에 거친 노드
            int INF = 987654321;
            for (int[] arr : dist) {
                  Arrays.fill(arr, INF);
            }

            int a, b, value;
            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());
                  value = Integer.parseInt(st.nextToken());
                  dist[a][b] = value;
                  dist[b][a] = value;
                  before[a][b] = b;
                  before[b][a] = a;
            }

            fluid(dist, before, N, M);

            int tmpA = 0;
            int tmpB = 0;
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        if(i == j){
                              bw.write("- ");
                              continue;
                        }

                        tmpA = j;
                        while(before[i][tmpA] != tmpA){    //같아질때까지
                              tmpA = before[i][tmpA];
                        }
                        bw.write(tmpA + " ");
                  }
                  bw.write('\n');
            }

            bw.close();

      }

      private static void fluid(int[][] dist, int[][] before, int N, int M){
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        for (int k = 1; k <= N; k++) {
                              if(j == k){
                                    dist[j][k] = j;
                                    before[j][k] = j;
                                    continue;
                              }
                              if(dist[j][k] > dist[j][i] + dist[i][k]){
                                    dist[j][k] = dist[j][i] + dist[i][k];
                                    before[j][k] = i;
                              }
                        }
                  }
            }
      }

}
