import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static class Pair{
            int areaNum;
            int dist;

            public Pair(int areaNum, int dist){
                  this.areaNum = areaNum;
                  this.dist = dist;
            }
      }
      static int N, M, R; //지역개수, 수색범위, 길 개수
      static int maxSum = 0;
      static int[] items;
      static int[] visited;
      static int[][] distance;
      static int INF = 2000;

      static ArrayList<Pair>[] list;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            items = new int[N + 1];
            distance = new int[N + 1][N + 1];

            // 자기자신은 0, 아닌경우 INF로 초기화
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        if(i == j) continue;
                        distance[i][j] = INF;
                  }
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                  items[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < R; i++) {
                  st = new StringTokenizer(br.readLine());
                  int a = Integer.parseInt(st.nextToken());
                  int b = Integer.parseInt(st.nextToken());
                  int c = Integer.parseInt(st.nextToken());

                  distance[a][b] = c;
                  distance[b][a] = c;
            }

            fluid();

            int tmp;
            for (int i = 1; i <= N; i++) {
                  tmp = 0;
                  for (int j = 1; j <= N; j++) {
                        if(distance[i][j] > M) continue;
                        tmp += items[j];
                  }
                  maxSum = Math.max(maxSum, tmp);
            }

            System.out.println(maxSum);
      }
      // 노드 간 간선이 여러개일수도 있기 때문에 방문체크를 하게되면 힘들다..

      // j->k를 가는것보다 j->i->k로 가는 비용이 적게든다면 초기화
      static void fluid(){
            for (int i = 1; i <= N; i++) {
                  for (int j = 1; j <= N; j++) {
                        for (int k = 1; k <= N; k++) {
                              if(distance[j][k] > distance[j][i] + distance[i][k]){
                                    distance[j][k] = distance[j][i] + distance[i][k];
                              }
                        }
                  }
            }
      }
}
