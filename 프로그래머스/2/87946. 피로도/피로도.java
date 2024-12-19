class Solution {
    static int dungeonCnt;
    // static boolean[] visit;
    static int maxCnt = -987654321;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dungeonCnt = dungeons.length;
        // System.out.println(dungeonCnt);
        boolean[] visit = new boolean[dungeonCnt];
        
        recur(k, visit, 1, 0, dungeons);

        return maxCnt;
    }
    
    public void recur(int hp, boolean[] visit, int depth, int cnt, int[][] dungeons){
        maxCnt = Math.max(maxCnt, cnt);
        if(depth > dungeonCnt) return;
           
        int newHp;
        for(int i=0; i<dungeonCnt; i++){
            if(hp >= dungeons[i][0] && !visit[i]){
                newHp = hp - dungeons[i][1];
                visit[i] = true;
                recur(newHp, visit, depth + 1, cnt + 1, dungeons);
                visit[i] = false;
            }
        }
    }
}