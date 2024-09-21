import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      static int R, C;
      static int[][] map;
      static ArrayList<CCTV> cctvList = new ArrayList<>();
      static int minSquareArea = Integer.MAX_VALUE;
      static int cctvCnt = 0;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];

            for (int i = 0; i < R; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < C; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                        if(map[i][j] != 0 && map[i][j] != 6) {
                              cctvList.add(new CCTV(i, j, map[i][j]));
                              cctvCnt++;
                        }
                  }
            }

            dfs(0, map);
            System.out.println(minSquareArea);


      }

      static class CCTV{
            int x;
            int y;
            int kind;

            public CCTV(int x, int y, int kind){
                  this.x = x;
                  this.y = y;
                  this.kind = kind;
            }
      }
      private static void dfs(int cctvIdx, int[][] map){
            if(cctvIdx >= cctvCnt){
                  //사각지대 개수 구하기, 갱신
                  int cnt = 0;
                  for(int i=0; i<R; i++){
                        for(int j=0; j<C; j++){
                              if(map[i][j] == 0) cnt++;
                        }
                  }
                  minSquareArea = Math.min(minSquareArea, cnt);

//                  int tmp = 0;
//                  for(int[] arr : map){
//                        System.out.println(Arrays.toString(arr));
//                  }
//                  System.out.println();
                  return;
            }

            int[][] newMap = new int[R][C];
            mapCopy(map, newMap);

            CCTV curCctv = cctvList.get(cctvIdx);
            if(curCctv.kind == 1){
                  for(int i=0; i<4; i++){
                        mapCopy(cctvNumOne(i, map, curCctv.x, curCctv.y), newMap);
                        dfs(cctvIdx + 1, newMap);
                  }
            }else if(curCctv.kind == 2){
                  for(int i=0; i<2; i++){
                        mapCopy(cctvNumTwo(i, map, curCctv.x, curCctv.y), newMap);
                        dfs(cctvIdx + 1, newMap);
                  }
            }else if(curCctv.kind == 3){
                  for(int i=0; i<4; i++){
                        mapCopy(cctvNumThree(i, map, curCctv.x, curCctv.y), newMap);
                        dfs(cctvIdx + 1, newMap);
                  }
            }else if(curCctv.kind == 4){
                  for(int i=0; i<4; i++){
                        mapCopy(cctvNumFour(i, map, curCctv.x, curCctv.y), newMap);
                        dfs(cctvIdx + 1, newMap);
                  }
            }else{
                  mapCopy(cctvNumFive(0, map, curCctv.x, curCctv.y), newMap);
                  dfs(cctvIdx + 1, newMap);
            }
      }

      private static boolean dirCheck(int x, int y){
            if(x >= 0 && x < R && y >= 0 && y < C && map[x][y] != 6) return true;
            else return false;
      }
      private static int[][] cctvNumOne(int dir, int[][] map, int x, int y){
            int[][] newMap = new int[R][C];
            int tmp = 0;
            for(int[] arr : map){
                  newMap[tmp++] = Arrays.copyOf(arr, arr.length);
            }
            if(dir == 0){
                  for (int i = x - 1; i >= 0; i--) {
                        if(!dirCheck(i, y)) break;
                        if(map[i][y] >= 1 && map[i][y] <= 5) continue;  //cctv는 건너뛰어도됨
                        newMap[i][y] = 7;
                  }
            }else if(dir == 1){     //우
                  for (int i = y + 1; i < C; i++) {
                        if(!dirCheck(x, i)) break;
                        if(map[x][i] >= 1 && map[x][i] <= 5) continue;  //cctv는 건너뛰어도됨
                        newMap[x][i] = 7;

                  }
            }else if(dir == 2){ //하
                  for (int i = x + 1; i < R; i++) {
                        if(!dirCheck(i, y)) break;
                        if(map[i][y] >= 1 && map[i][y] <= 5) continue;
                        newMap[i][y] = 7;

                  }
            }else if(dir == 3){ //좌
                  for (int i = y - 1; i >= 0; i--) {
                        if(!dirCheck(x, i)) break;
                        if(map[x][i] >= 1 && map[x][i] <= 5) continue;
                        newMap[x][i] = 7;
                  }
            }

            return newMap;
      }

      private static int[][] cctvNumTwo(int dir, int[][] map, int x, int y){
            int[][] newMap = new int[R][C];
            int tmp = 0;
            for(int[] arr : map){
                  newMap[tmp++] = Arrays.copyOf(arr, arr.length);
            }

            if(dir == 0){     //양쪽
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
            }else if(dir == 1){     //위아래
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
            }

            return newMap;
      }

      private static int[][] cctvNumThree(int dir, int[][] map, int x, int y){
            int[][] newMap = new int[R][C];
            mapCopy(map, newMap);

            if(dir == 0){     //위, 오른
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
            }else if(dir == 1){ //오른, 아래
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
            }else if(dir == 2){ //왼, 아래
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
            }else if(dir == 3){ // 왼, 위
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
            }

            return newMap;
      }

      private static int[][] cctvNumFour(int dir, int[][] map, int x, int y){
            int[][] newMap = new int[R][C];
            mapCopy(map, newMap);

            if(dir == 0){     //왼, 위, 오른
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
            }else if(dir == 1){ //위,오른, 아래
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
            }else if(dir == 2){ //왼, 아래, 오른
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(1, newMap, x, y), newMap);
            }else if(dir == 3){ // 왼, 위, 아래
                  mapCopy(cctvNumOne(3, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(0, newMap, x, y), newMap);
                  mapCopy(cctvNumOne(2, newMap, x, y), newMap);
            }

            return newMap;
      }

      private static int[][] cctvNumFive(int dir, int[][] map, int x, int y){
            int[][] newMap = new int[R][C];
            mapCopy(map, newMap);

            mapCopy(cctvNumOne(0, newMap, x, y), newMap);
            mapCopy(cctvNumOne(1, newMap, x, y), newMap);
            mapCopy(cctvNumOne(2, newMap, x, y), newMap);
            mapCopy(cctvNumOne(3, newMap, x, y), newMap);

            return newMap;
      }


      private static void mapCopy(int[][] mapA, int[][] mapB){
            // a -> b 깊은복사
            int tmp = 0;
            for(int[] arr : mapA){
                  mapB[tmp++] = Arrays.copyOf(arr, arr.length);
            }
      }

}
