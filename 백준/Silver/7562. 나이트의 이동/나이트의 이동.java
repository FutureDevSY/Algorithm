
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      static Queue<Point> queue;
      static int[][] check;
      static int[] dr = {-1, 1, 2, 2, 1, -1, -2, -2};
      static int[] dc = {-2, -2, -1, 1, 2, 2, -1, 1};
      static int lng, toGoX, toGoY;;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());

            for(int t=0; t<T; t++){
                  lng = Integer.parseInt(br.readLine());
                  check = new int[lng][lng];
                  int curRow, curCol;
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  curRow = Integer.parseInt(st.nextToken());
                  curCol = Integer.parseInt(st.nextToken());


                  st = new StringTokenizer(br.readLine());
                  toGoX= Integer.parseInt(st.nextToken());
                  toGoY = Integer.parseInt(st.nextToken());
                  queue = new LinkedList<>();
                  bfs(curRow, curCol);

                  bw.write(Integer.toString(check[toGoX][toGoY] - 1));
                  bw.newLine();
            }
            bw.close();
      }

      static void bfs(int x, int y){
            queue.add(new Point(x, y));
            check[x][y] = 1;

            while(!queue.isEmpty()){
                  Point p = queue.poll();
                  for(int i=0; i<8; i++){
                        int newX = (int)p.getX() + dr[i];
                        int newY = (int)p.getY() + dc[i];
                        if(newX >= 0 && newY >= 0 && newX < lng && newY < lng
                            && check[newX][newY] == 0){
                              check[newX][newY] = check[p.x][p.y] + 1;
                              if(newX == toGoX && newY == toGoY){
                                    return;
                              }
                              queue.add(new Point(newX, newY));
                        }

                  }
            }
      }


}
