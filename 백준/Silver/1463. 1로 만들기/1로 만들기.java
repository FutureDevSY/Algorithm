import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {  //dp로 푸는게 대표적이지만 bfs로도 함 풀어봄
    static Queue<Integer> queue = new LinkedList<>();   //큐 선언하는법 또 까먹었내.
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        visit = new int[N+1];
        bfs(N);
        bw.write(Integer.toString(visit[1]));
        bw.flush();
        bw.close();
    }
    static void bfs(int N) {
        queue.add(N);
        while (true) {
            int temp = queue.remove();
            if (temp == 1) {
                return;
            }
            if (temp % 3 == 0 && visit[temp / 3] == 0) {    //새로 큐에 넣을 노드를 방문체크 해야함!!
                queue.add(temp / 3);    //큐에 새 노드를 추가하고
                visit[temp / 3] = visit[temp] + 1;  //visit배열로 이전 노드값+1한값을 새 노드 위치에 저장한다
            }
            if (temp % 2 == 0 && visit[temp / 2] == 0) {
                queue.add(temp / 2);
                visit[temp / 2] = visit[temp] + 1;
            }
            if (visit[temp - 1] == 0) {
                queue.add(temp - 1);
                visit[temp-1] = visit[temp] + 1;
            }
        }

    }
}
