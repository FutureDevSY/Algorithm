import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K; //수빈위치, 동생위치
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 가장빠른 시간 / 방법 개수
        if(N == K){
            System.out.println(0);
            System.out.println(1);
        }else if (N > K){
            System.out.println(N - K);
            System.out.println(1);
        }else{
            bfs(N, K);
            System.out.println(minTime);
            System.out.println(minCnt);
        }

    }

    static class Node{
        int point;
        int time;

        Node(int p, int t){
            point = p;
            time = t;
        }
    }

    static int minTime = Integer.MAX_VALUE;
    static int minCnt = 0;

    static void bfs(int N, int K){
        Queue<Node> queue = new ArrayDeque<>();
        int[] visitedMin = new int[200000];
        Arrays.fill(visitedMin, Integer.MAX_VALUE);

        queue.add(new Node(N + 1, 1));
        queue.add(new Node(N * 2, 1));
        visitedMin[N + 1] = 1;
        visitedMin[N * 2] = 1;
        if(N != 0){
            queue.add(new Node(N - 1, 1));
            visitedMin[N - 1] = 1;
        }

        Node curNode;
        while(!queue.isEmpty()){
            curNode = queue.poll();

            //도달했음 체크
            if(curNode.point == K){
                if(curNode.time < minTime){
                    minTime = curNode.time;
                    minCnt = 1;
                }else if(curNode.time == minTime){
                    minCnt++;
                }
                continue;
            }

            //현재위치가 동생보다 앞서있다면
            if(curNode.point > K) {
                //뒤로이동해야함
                if(visitedMin[curNode.point - 1] >= curNode.time + 1){
                    queue.add(new Node(curNode.point - 1, curNode.time + 1));
                    visitedMin[curNode.point - 1] = curNode.time + 1;
                }
            }else{
                if(visitedMin[curNode.point + 1] >= curNode.time + 1) {
                    queue.add(new Node(curNode.point + 1, curNode.time + 1));
                    visitedMin[curNode.point + 1] = curNode.time + 1;
                }

                if(visitedMin[curNode.point * 2] >= curNode.time + 1){
                    queue.add(new Node(curNode.point * 2, curNode.time + 1));
                    visitedMin[curNode.point * 2] = curNode.time + 1;
                }

                if(curNode.point != 0){
                    if(visitedMin[curNode.point - 1] >= curNode.time + 1){
                        queue.add(new Node(curNode.point - 1, curNode.time + 1));
                        visitedMin[curNode.point - 1] = curNode.time + 1;
                    }
                }
            }
        }

    }
}
