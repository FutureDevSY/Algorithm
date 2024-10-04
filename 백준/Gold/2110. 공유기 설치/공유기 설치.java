import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static int[] houses;
      static int N, C;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //    집의 개수
            C = Integer.parseInt(st.nextToken()); //    공유기의 개수
            houses = new int[N];
            for (int i = 0; i < N; i++) {
                  houses[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(houses);

            int l = 1;
            int r = houses[N - 1];
            int m = (l + r) / 2;

            while (l <= r) {
                  int cnt = check(m);     //설정한 거리만큼 배치했을때 최대 설치가능한 공유기의 개수

                  if(cnt >= C){ //너무 많이 설치되었거나 C개만큼 설치했으면 거리 늘려본다
                        l = m + 1;
                  }else{ //너무 적게 설치되었으면 거리 줄여야함
                        r = m - 1;
                  }
                  m = (l + r) / 2;
            }

            System.out.println(m);
      }

      static int check(int dist){
            int cnt = 1;
            int latest = houses[0];   //  가장 최근 설치한 공유기 위치
            for (int i = 1; i < houses.length; i++) {
                  if(houses[i] - latest >= dist){
                        latest = houses[i];
                        cnt++;
                  }
            }
            return cnt;
      }

}
