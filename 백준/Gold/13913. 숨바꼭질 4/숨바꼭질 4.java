import java.io.*;
import java.util.*;

public class Main {  //백준 13913번 숨바꼭질 문제
    static ArrayList<ArrayList<Integer>> al;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> path = new ArrayList<>();
    static int[] visited;
    static int[] from;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());   //시작할 위치
        int end = Integer.parseInt(st.nextToken());   //도착할 위치
        int max = end;
        if (start > end) {
            max = start;
        }
        max = max + 2;
        visited = new int[max];
        from = new int[max];
        al = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < max; i++) {
            if (i - 1 >= 0 && i - 1 < max) {
                al.get(i).add(i - 1);
            }
            if (i + 1 >= 0 && i + 1 < max) {
                al.get(i).add(i + 1);
            }
            if (i * 2 >= 0 && i * 2 < max) {
                al.get(i).add(i * 2);
            }
        }

        bw.write(Integer.toString(bfs(start, end)));
        bw.newLine();

        for (int i = end; i != start; i = from[i]) {
            stack.push(i);
        }
        stack.push(start);

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int s, int e) {     //시작점, 도착점
        int now = s;    //현위치
        queue.add(now);
        while (now != e) {  //e에 도달할떄까지
            now = queue.remove();
            for (int i : al.get(now)) {
                if (visited[i] == 0) {  //범위가 0~end 내의 범위이면서 방문 안했을떄
                    queue.add(i);
                    from[i] = now;  //어디에서 왔는지 이전 정보 저장
                    visited[i] = visited[now] + 1;  //이부분이 중요!
                }
            }

        }
        return visited[now];
    }

}