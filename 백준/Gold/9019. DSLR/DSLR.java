import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int A, B;
            for (int t = 0; t < T; t++) {
                  st = new StringTokenizer(br.readLine());
                  A = Integer.parseInt(st.nextToken());
                  B = Integer.parseInt(st.nextToken());
                  //A에서 B로 변환할수있는 최소한의 명령어 수
                  bw.write(bfs(A, B) + '\n');
            }
            bw.close();
//            System.out.println(left(left(1234)));

      }

      static class Node{
            int num;
            String order;
            public Node(int num, String order){
                  this.num = num;
                  this.order = order;
            }
      }

      private static String bfs(int A, int B){
            Queue<Node> queue = new ArrayDeque();
            HashSet<Integer> visited = new HashSet<>();
            queue.add(new Node(A, ""));
            visited.add(A);

            Node curNode;
            int curVal;
            int tmpVal;
            while(!queue.isEmpty()){
                  curNode = queue.poll();
//                  System.out.println(curNode.num);
                  if(curNode.num == B){
                        return curNode.order;
                  }
                  curVal = curNode.num;
//                  visited.add(curVal);
                  //D
                  if (curVal * 2 > 9999) {
                        if(!visited.contains(curVal * 2 % 10000)){
                              queue.add(new Node(curVal * 2 % 10000, curNode.order + "D"));
                              visited.add(curVal * 2 % 10000);
                        }
                  } else {
                        if(!visited.contains(curVal * 2)){
                              queue.add(new Node(curVal * 2, curNode.order + "D"));
                              visited.add(curVal * 2);
                        }
                  }
                  //S
                  if(curVal == 0){
                        if(!visited.contains(9999)){
                              queue.add(new Node(9999, curNode.order + "S"));
                              visited.add(9999);
                        }
                  }
                  else {
                        if(!visited.contains(curVal - 1)){
                              queue.add(new Node(curVal - 1, curNode.order + "S"));
                              visited.add(curVal - 1);
                        }

                  }
                  //L
                  tmpVal = left(curVal);
                  if(!visited.contains(tmpVal)){
                        queue.add(new Node(tmpVal, curNode.order + "L"));
                        visited.add(tmpVal);
                  }
                  tmpVal = right(curVal);
                  //R
                  if(!visited.contains(tmpVal)){
                        queue.add(new Node(tmpVal, curNode.order + "R"));
                        visited.add(tmpVal);
                  }

            }

            return "";
      }

      private static int left(int data){
            // 1234
            // 234 -> 2340 -> 2341
//            int tmpA = num % (1000); //다 네자리라고 가정해도 됨
//            int tmpB = num / 1000;
//            return (tmpA * 10) + tmpB;
            int temp3 = (data/1000);
            return data%1000*10 +temp3 ;
      }

      private static int right(int data){
            // 0120 ->
//            int tmpA = num / 10; //12
//            int tmpB = num % 10;
//            return (1000 * tmpB) + tmpA;

            int temp4 = data%10;
            return temp4*1000+data/10;
      }

}
