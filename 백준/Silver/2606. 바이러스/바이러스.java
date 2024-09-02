import java.io.*;
import java.util.*;

public class Main {

      static int count;
      static int[] check;
      static final int VIRUS_CPT = 1;
      static int virused = 0;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;

            int cptCnt = Integer.parseInt(br.readLine());    //컴퓨터 수
            int connections = Integer.parseInt(br.readLine());    //연결된 컴퓨터 쌍 수

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            for(int i=0; i<=cptCnt; i++){
                  list.add(new ArrayList<Integer>());
            }

            int a, b;
            for(int i=0; i<connections; i++){
                  st = new StringTokenizer(br.readLine());
                  a = Integer.parseInt(st.nextToken());
                  b = Integer.parseInt(st.nextToken());

                  list.get(a).add(b);
                  list.get(b).add(a);
            }

            boolean[] isVisited = new boolean[cptCnt + 1];

            bfs(list, isVisited);

            bw.write(Integer.toString(virused));
            bw.close();

      }

      static void bfs(ArrayList<ArrayList<Integer>> list, boolean[] isVisited){
            Queue<Integer> q = new LinkedList<>();
            q.add(VIRUS_CPT);    //최초 감염 컴퓨터 번호
            isVisited[VIRUS_CPT] = true;
            int n;

            while(!q.isEmpty()){
                  n = q.poll();

//                  System.out.println("n:" + n);

                  for(int i : list.get(n)){
                        if(!isVisited[i]) {
                              isVisited[i] = true;
                              virused++;
                              q.add(i);
                        }
                  }


            }

      }

}
