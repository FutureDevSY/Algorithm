import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < progresses.length; i++){
            //남은 일수 계산
            q.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
            System.out.println(q.peek());
        }
        
        while(!q.isEmpty()){
            int first = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && first >= q.peek()){
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        
        return result;
        
    }
}
