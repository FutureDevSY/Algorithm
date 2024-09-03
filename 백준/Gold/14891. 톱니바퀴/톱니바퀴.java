import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //톱니바퀴 문제
      static int[][] wheels;
      static int[][] tmpWheels;

      public static void main(String[] args) throws IOException {
            wheels = new int[4][8];
            tmpWheels = new int[4][8];
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] intArr;
            String intStr;
            for (int i = 0; i < 4; i++) {
                  intStr = br.readLine();
                  intArr = Arrays.stream(intStr.split(""))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
                  wheels[i] = intArr;
            }

            int K = Integer.parseInt(br.readLine());  //회전 횟수
            int wheelToRotate;      //회전시킬 중심 바퀴
            int rotate;       //회전방향
            int[] state;     //0: 회전하지않음, 1: 시계방향으오 회전해야함, -1: 반시계로
            StringTokenizer st;
            for (int k = 0; k < K; k++) { //K번만큼 회전시키기
                  st = new StringTokenizer(br.readLine());
                  wheelToRotate = Integer.parseInt(st.nextToken()) - 1;
                  rotate = Integer.parseInt(st.nextToken());
                  state = new int[4];
                  state[wheelToRotate] = rotate;

                  //회전중심 바퀴 기준으로 왼쪽 바퀴들 살피기
                  int leftSide = wheelToRotate - 1;
                  int wheelToCompare = wheelToRotate;
                  int rotateTmp = rotate;
                  while (leftSide >= 0) {
                        if(wheels[leftSide][2] == wheels[wheelToCompare][6]) break;  //극이 같으므로 움직일필요 없음
                        else{
                              state[leftSide] = -rotateTmp;
                        }
                        wheelToCompare = leftSide;
                        leftSide--;
                        rotateTmp = -rotateTmp;
                  }

                  wheelToCompare = wheelToRotate;

                  //회전중심 바퀴 기준으로 오른쪽 바퀴들 살피기
                  int rightSide = wheelToRotate + 1;
                  rotateTmp = rotate;
                  while (rightSide < 4) {
                        if(wheels[rightSide][6] == wheels[wheelToCompare][2]) break;  //극이 같으므로 움직일필요 없음
                        else{
                              state[rightSide] = -rotateTmp;
                        }
                        wheelToCompare = rightSide;
                        rightSide++;
                        rotateTmp = -rotateTmp;
                  }

                  //체크 끝나면 회전시키기
                  tmpWheels = new int[4][8];
                  for (int i = 0; i < state.length; i++) {
                        if(state[i] == 1) rotateToRight(i);
                        else if(state[i] == -1) rotateToLeft(i);
                  }
                  //회전을 다 끝내고 해당 부분만 반영해야함
                  for (int i = 0; i < 4; i++) {
                        if(state[i] != 0) wheels[i] = tmpWheels[i];
                  }

            }

            //점수 계산, 0이면 뭐든 0점 1이라면 0 1 2 3 순으로 각 1 2 4 8점
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                  if(wheels[i][0] == 0) continue;
                  sum += Math.pow(2, i);
            }

            System.out.println(sum);


      }
      static void rotateToRight(int toRotate){
            //왼 -> 오;, 오른쪽부터 확인
            for (int i = 0; i < 8; i++) {
                  if(i == 0) tmpWheels[toRotate][i] = wheels[toRotate][7];
                  else tmpWheels[toRotate][i] = wheels[toRotate][i - 1];
            }
      }

      static void rotateToLeft(int toRotate){
            //오 -> 왼
            for (int i = 0; i < 8; i++) {
                  if(i == 7) tmpWheels[toRotate][i] = wheels[toRotate][0];
                  else tmpWheels[toRotate][i] = wheels[toRotate][i + 1];
            }
      }
}
