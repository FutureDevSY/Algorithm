class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String str;
        int idx;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        for(int i=0; i<babbling.length; i++){
            str = babbling[i];
            
            for(int j=0; j<canSpeak.length; j++){
                idx = str.indexOf(canSpeak[j]);
                if(idx != -1) {
                    // System.out.println(canSpeak[j] + " " + str);
                    str = str.replace(canSpeak[j], " ");
                    
                }
            }
            str = str.replace(" ", ""); 
            
            if(str.length() == 0) answer++;
        }
        
        return answer;
    }
}