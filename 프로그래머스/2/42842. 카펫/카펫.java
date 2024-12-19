class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int right = brown / 2;
        int left = 3;
        int mid = 0;
        int height;
    
        int tmpResult = 0;
        
        while(left <= right){
            mid = (left + right) / 2;
            tmpResult = (mid - 2) * ((brown - (mid * 2)) / 2); //노란 타일의 갯수 계산
            System.out.println(tmpResult);
            if(tmpResult == yellow) break;
            else if(tmpResult > yellow) left = mid + 1;
            else right = mid - 1;
        }
        
        answer[0] = mid;
        answer[1] = (brown - (mid * 2)) / 2 + 2;
        
        return answer;
    }
}