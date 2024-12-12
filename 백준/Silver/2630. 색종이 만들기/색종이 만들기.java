import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      static int[][] map;
      static int cntBlue = 0;
      static int cntWhite = 0;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < N; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                  }
            }

            cut(N, 0, 0);
            System.out.println(cntWhite);
            System.out.println(cntBlue);

      }

      static void cut(int size, int startX, int startY){
            if(isAllSame(size, startX, startY)){
                  if(map[startX][startY] == 1) cntBlue++;
                  else cntWhite++;
            }else{
                  cut(size / 2, startX, startY);
                  cut(size / 2, startX, startY + (size / 2));
                  cut(size / 2, startX + (size / 2), startY);
                  cut(size / 2, startX + (size / 2), startY + (size / 2));
            }
      }

      private static boolean isAllSame(int size, int startX, int startY) {
            int val = map[startX][startY];
            for (int i = startX; i < startX + size; i++) {
                  for (int j = startY; j < startY + size; j++) {
                        if(map[i][j] != val) return false;
                  }
            }
            return true;
      }
}
