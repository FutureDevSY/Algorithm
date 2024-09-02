import java.io.*;
import java.util.*;

public class Main {  //백준 1697번 숨바꼭질 문제
    static ArrayList<ArrayList<Integer>> al;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;

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
        max = max * 2 + 1;
        visited = new int[max];
        Arrays.fill(visited, -1);   //0대신 -1값이 방문 안함의 의미를 갖게할것임
        al = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < max; i++) {
            if (i * 2 >= 0 && i * 2 < max) {
                al.get(i).add(i * 2);
            }
            if (i - 1 >= 0 && i - 1 < max) {
                al.get(i).add(i - 1);
            }
            if (i + 1 >= 0 && i + 1 < max) {
                al.get(i).add(i + 1);
            }
        }

        bw.write(Integer.toString(bfs(start, end)));
        bw.flush();
        bw.close();
    }

    static int bfs(int s, int e) {     //시작점, 도착점
        int now = s;    //현위치
        queue.add(now);
        visited[now] = 0;   //맨 처음 시작점은 0으로 방문한거 따로 체크
        while (now != e) {  //e에 도달할떄까지
            now = queue.remove();
            for (int i : al.get(now)) {
                if (visited[i] == -1) {
                    queue.add(i);
                    if (now * 2 == i) {
                        visited[i] = visited[now];
                    } else {
                        visited[i] = visited[now] + 1;
                    }

                }
            }
        }
        return visited[now];
    }

}
