class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int strLng = A.length();
        int idx;
        StringBuilder sb;

        if(A.equals(B)) return 0;

        for(int i=strLng - 1; i >= 0; i--){
            sb = new StringBuilder();
            for(int j=i; j < i + strLng; j++){
                idx = j;
                if(j > strLng - 1) idx = j - strLng;
                sb.append(A.charAt(idx));
            }
            // System.out.println(sb.toString());
            if(B.equals(sb.toString())) {
                answer = strLng - i;
                break;
            }
        }
        
        return answer;
    }
}