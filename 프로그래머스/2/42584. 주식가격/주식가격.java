import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] remainTime = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int tmp = 0;
        
        for(int i=1; i<prices.length; i++){
            if(stack.isEmpty()) stack.add(i);
            else if(prices[i] >= prices[stack.peek()]){
                stack.add(i);
            }else{
                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                    tmp = stack.pop();
                    remainTime[tmp] = i - tmp;
                }
                stack.add(i);
            }
        }
        
        while(!stack.isEmpty()){
            tmp = stack.pop();
            remainTime[tmp] = (prices.length - 1) - tmp;
        }
        
        return remainTime;
    }
}