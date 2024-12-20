class Solution {
    static boolean found;
    static int resultOrder;
    static char[] group = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        return recur(word, new StringBuilder(), word.length());
    }
    
    static int ord;
    
    public int recur(String word, StringBuilder sb, int wordLng){
        if(wordLng == sb.length()){
            if(sb.toString().equals(word)){
                return ord;
            }
        }
        
        int tmp;
        if(sb.length() < 5){
            for(int i=0; i<5; i++){
                ord++;
                tmp = recur(word, sb.append(group[i]), wordLng);
                if (tmp != -1){
                    return ord;
                }else if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }    
        }
        
        return -1;
        
    }
}