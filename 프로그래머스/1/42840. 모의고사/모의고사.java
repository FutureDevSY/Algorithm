import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int lng = answers.length;
        
        //1번방식
        int[] supoA = {1,2,3,4,5};
        int[] supoB = {2,1,2,3,2,4,2,5};
        int[] supoC = {3,3,1,1,2,2,4,4,5,5};
        
        int[] supoCnt = new int[3];
        
        int curA = 0;
        int curB = 0;
        int curC = 0;
        
        for(int i=0; i<lng; i++){
            if(curA >= supoA.length) curA = 0;
            if(curB >= supoB.length) curB = 0;
            if(curC >= supoC.length) curC = 0;
            
            if(answers[i] == supoA[curA]) supoCnt[0]++;
            if(answers[i] == supoB[curB]) supoCnt[1]++;
            if(answers[i] == supoC[curC]) supoCnt[2]++;
            
            curA++;
            curB++;
            curC++;
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        int max = Math.max(supoCnt[0], Math.max(supoCnt[1], supoCnt[2]));
        
        for(int i=0; i<3; i++){
            if(supoCnt[i] == max){
                al.add(i + 1);
            }
        }
        
        answer = new int[al.size()];
        int idx = 0;
        for(int i : al){
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }
}