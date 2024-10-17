import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        Queue<Integer> wait = new ArrayDeque<>();
        for(int w : truck_weights){
            wait.add(w);
        }
        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }        
        
        int time = 0;
        int check = 0;
        int curWeightSum = 0;
        int tmp = 0;
        while(check != truck_weights.length){
            time++;
            tmp = bridge.poll();
            curWeightSum = curWeightSum - tmp;

            if(tmp != 0) {
                check++;   
            }
            
            if(!wait.isEmpty() && curWeightSum + wait.peek() <= weight){
                tmp = wait.poll();
                bridge.add(tmp);
                curWeightSum = curWeightSum + tmp;
            }else bridge.add(0);
            

        }
        
        return time;
    }
}