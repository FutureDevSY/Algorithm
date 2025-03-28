class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        //건널수 있는 인원의 최대는 200000000
        
        int left = 0;
        int right = 200000000;
        int mid;
        int tmpMaxCnt = 0;
        while(left<=right){
            mid = (left + right) / 2;
            tmpMaxCnt = countMaxEmpty(mid - 1, stones);
            // System.out.println(mid + " " + tmpMaxCnt);
            if(tmpMaxCnt >= k){
                right = mid - 1;
            }else{
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        
        return answer;
    }
    //뛰어넘어야 하는 이어진 빈 돌다리 개수 세기
    public int countMaxEmpty(int mid, int[] stones){
        int maxCnt = 0;
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i] - mid <= 0){
                cnt++;
                maxCnt = Integer.max(maxCnt, cnt);
            }else{
                cnt = 0;
            }
        }
        return maxCnt;
    }
}