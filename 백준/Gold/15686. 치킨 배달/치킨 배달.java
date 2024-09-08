import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main { //치킨배달
      static int N, M;
      static ArrayList<Node> picked;
      static int[][] city;
      static int chickenLngMin;

      public static void main(String[] args) throws IOException  {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());      //크기
            M = Integer.parseInt(st.nextToken());      //최대 치킨집 개수
            city = new int[N][N];
            ArrayList<Node> chickens = new ArrayList<>();
            ArrayList<Node> houses = new ArrayList<>();

            int tmpC = 0;
            int tmpH = 0;
            for (int i = 0; i < N; i++) {
                  st = new StringTokenizer(br.readLine());
                  for (int j = 0; j < N; j++) {
                        city[i][j] = Integer.parseInt(st.nextToken());
                        if(city[i][j] == 2){
                              chickens.add(new Node(i, j));
                        }else if(city[i][j] == 1){
                              houses.add(new Node(i, j));
                        }
                  }
            }

            chickenLngMin = Integer.MAX_VALUE;
            //치킨집에 대한 조합 구하기
            for (int i = 1; i <= M; i++) {
                  picked = new ArrayList<>();
                  choose(chickens, i, 0, 0, houses);
            }

            System.out.println(chickenLngMin);
      }

      public static void choose(ArrayList<Node> chickens, int cnt, int cntSum, int start, ArrayList<Node> houses){
            if(cntSum >= cnt){
                  chickenLngMin = Math.min(chickenLngMin, chickenLng(picked, houses));
                  return;
            }

            for (int i = start; i < chickens.size(); i++) {
                   picked.add(chickens.get(i));
                  choose(chickens, cnt, cntSum + 1, i + 1, houses);
                  picked.remove(chickens.get(i));

            }

      }

      public static int chickenLng(ArrayList<Node> picked, ArrayList<Node> houses){
            Node curHouse, curChicken;
            int curLng = Integer.MAX_VALUE; //현재 집의 치킨거리
            int chickenLngSum = 0;      //총 치킨거리

            for (int i = 0; i < houses.size(); i++) {
                  curHouse = houses.get(i);
                  for (int j = 0; j < picked.size(); j++) {
                        curChicken = picked.get(j);
                        curLng = Math.min(curLng, (Math.abs(curHouse.x - curChicken.x) + Math.abs(curHouse.y - curChicken.y)));
                  }
                  chickenLngSum += curLng;
                  curLng = Integer.MAX_VALUE;
            }

            return chickenLngSum;
      }


      public static class Node{   //각 차킨집의 위치를 나타낼 클래스
            int x;
            int y;

            public Node(int x, int y){
                  this.x = x;
                  this.y = y;
            }
      }

}
