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
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int ax, ay, bx, by;
        //바깥 0 테두리 1 안쪽 -1
        int[][] map = new int[101][101];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int i=0; i<rectangle.length; i++){
            ax = rectangle[i][0] * 2;
            ay = rectangle[i][1] * 2;
            bx = rectangle[i][2] * 2;
            by = rectangle[i][3] * 2;
            
            for(int x=ax; x<= bx; x++){
                for(int y=ay; y<= by; y++){
                    if(map[x][y] == -1) continue;
                    if(x == ax || x == bx || y ==ay || y == by) map[x][y] = 1;
                    else map[x][y] = -1;
                }
            }
        }
        
        return bfs(characterX, characterY, itemX, itemY, map) / 2;
    }
    
    static int[] dirx = {0, 1, 0, -1};
    static int[] diry = {-1, 0, 1, 0};
    
    static int bfs(int characterX, int characterY, int itemX, int itemY, int[][] map){
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        queue.add(new Pair(characterX, characterY, 0));
        visited[characterX][characterY] = true;
        
        Pair curPair;
        int nx, ny;
        while(!queue.isEmpty()){
            curPair = queue.poll();
            if(curPair.x == itemX && curPair.y == itemY) return curPair.count;
            
            for(int i=0; i<4; i++){
                nx = curPair.x + dirx[i];
                ny = curPair.y + diry[i];
                if(nx < 0 || nx >= 101 || ny < 0 || ny >= 101 || visited[nx][ny] || map[nx][ny] != 1) continue;
                queue.add(new Pair(nx, ny, curPair.count + 1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
    
    
    
    
    
    
}