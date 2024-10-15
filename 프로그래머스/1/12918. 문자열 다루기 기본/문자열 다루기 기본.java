class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        int sLng = s.length();
        
        boolean isDigit = true;
        for(int i=0; i<sLng; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') continue;
            else isDigit = false;
        }
        
        if(isDigit && (sLng == 4 || sLng == 6)) answer = true;
        
        return answer;
    }
}