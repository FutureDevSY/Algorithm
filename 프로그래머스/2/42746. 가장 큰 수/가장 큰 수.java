import java.util.*;

class Solution {
    static class Num implements Comparable<Num>{
        int val;
        
        public Num(int num){
            val = num;
        }
        
        @Override
        public int compareTo(Num n){
            if(n.val == this.val) return n.val - this.val;
            else{
                String strA = Integer.toString(n.val);
                String strB = Integer.toString(this.val);
                return (strA + strB).compareTo(strB + strA);
            }

        }
    }
    public String solution(int[] numbers) {
        Num[] nums = new Num[numbers.length];
        int idx = 0;
        for(int i : numbers){
            nums[idx++] = new Num(i);
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(Num n : nums){
            sb.append(n.val);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}