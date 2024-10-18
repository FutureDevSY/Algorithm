import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> revPq = new PriorityQueue<>(Collections.reverseOrder());
        
        String order;
        int opeNum;
        StringTokenizer st;
        Character ope;
        int lng = 0;
        int tq = 0;
        for(int i=0; i<operations.length; i++){
            ope = operations[i].charAt(0);
            opeNum = Integer.parseInt(operations[i].substring(2));
            // System.out.println(opeNum);
            // ope = st.nextToken();
            // opeNum = Integer.parseInt(st.nextToken());
            // if(lng == 0){
            //     pq = new PriorityQueue<>();
            //     revPq = new PriorityQueue<>();
            // }
            
            if(ope == 'I'){
                pq.add(opeNum);
                revPq.add(opeNum);
                lng++;
            }else if(ope == 'D' && opeNum == 1 && lng > 0){
                tq = revPq.poll();
                pq.remove(tq);
                lng--;
            }else if(ope == 'D' && opeNum == -1 && lng > 0){
                tq = pq.poll();
                revPq.remove(tq);
                lng--;
            }
        }
        
        for(int i : pq){
            System.out.print(i + " ");
        }
        System.out.println();
        
        for(int i : revPq){
            System.out.print(i + " ");
        }
        System.out.println();


        // HashSet<Integer> set = new HashSet<>();
        // int tmp;
        // while(!pq.isEmpty()){
        //     set.add(pq.poll());
        // }
        
//         for(int i : set){
//             System.out.print(i + " ");
//         }
//         System.out.println();
        
//         ArrayList<Integer> both = new ArrayList<>();
//         int size = set.size();
//         int p, rp;
        
//         while(!revPq.isEmpty()){
//             p = revPq.poll();
//             set.add(p);
//             tmp = set.size();
            
//             if(size == tmp){
//                 both.add(p);
//                 // System.out.println(p);
//             }
//             size = tmp;
//         }
        
   
        
        int[] result = new int[2];
        if(lng  == 0) return result;
        
        // for(int i : both){
        //     System.out.print(i + " ");
        // }
        
        // Collections.sort(both);
        result[0] = revPq.poll();
        result[1] = pq.poll();
        
        return result;
    }
}