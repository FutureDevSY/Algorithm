import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sco : scoville){
            pq.add(sco);
        }
        
        int time = 0;
        int tmpA = 0;
        int tmpB = 0;
        
        while(pq.peek() < K){
            if(pq.size() < 2){
                time = -1;
                break;
            }
            
            time++;
            
            tmpA = pq.poll();
            tmpB = pq.poll();
            pq.add(tmpA + tmpB * 2);    
        }
        
        return time;
        
    }
}