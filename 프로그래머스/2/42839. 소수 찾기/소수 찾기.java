import java.util.*;


class Solution {
    public static int count = 0;
    public static int N;
    public static char[] charArr;
    public static HashSet<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        charArr = numbers.toCharArray();
        set = new HashSet<>();
        
        //조합
        boolean[] check = new boolean[N];
        recur("", 1, check);
        
        return count;
    }
    
    public void recur(String str, int depth, boolean[] check){
        if(depth > N){
            if(str.isEmpty()) return;
            
            int pi = Integer.parseInt(str);
            if(!set.contains(pi) && isSosu(pi)){
                System.out.println(pi);
                count++;
                set.add(pi);
            }
            return;
            
        }else{
            recur(str, depth + 1, check);
            String tmpStr;
            for(int i=0; i<N; i++){
                if(check[i]) continue;
                tmpStr = str + charArr[i];
                check[i] = true;
                recur(tmpStr, depth + 1, check);
                check[i] = false;
            }    
        }
        
        
    }
    
    public boolean isSosu(int x){
        if(x == 0 || x == 1) return false;
        for(int i=2; i < x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}