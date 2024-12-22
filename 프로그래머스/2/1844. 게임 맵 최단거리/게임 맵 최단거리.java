import java.util.*;

class Solution {
    
    static class Pair{
        int x;
        int y;
        int count;
        
        public Pair(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length; 
        int M = maps[0].length;
        // System.out.println(N + " " + M);
     
        return bfs(N, M, maps);
    }
    private static int[] dirx = {0, 1, 0, -1};
    private static int[] diry = {-1, 0, 1, 0};
    
    private static int bfs(int N, int M, int[][] maps){
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Pair(0,0,1));
        visited[0][0] = true;
        
        Pair curPair;
        int nextx, nexty;
        while(!queue.isEmpty()){
            curPair = queue.poll();
            if(curPair.x == N - 1 && curPair.y == M - 1) return curPair.count;
            
            for(int i=0; i<4; i++){
                nextx = curPair.x + dirx[i];
                nexty = curPair.y + diry[i];
                if(nextx < 0 || nextx >= N || nexty < 0 || nexty >= M || visited[nextx][nexty] || maps[nextx][nexty] == 0) continue;
                queue.add(new Pair(nextx, nexty, curPair.count + 1));
                visited[nextx][nexty] = true;
            }
        }
        return -1;
    }
}