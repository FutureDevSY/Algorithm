import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        return bfs(begin, target, words.length, words);
    }
    
    public class Node{
        String str;
        int cnt;
        
        Node(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int bfs(String begin, String target, int lng, String[] words){
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[lng];
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            for(int i=0; i<lng; i++){
                if(!visited[i] && check(curNode.str, words[i])){
                    if(words[i].equals(target)) return curNode.cnt + 1;
                    queue.add(new Node(words[i], curNode.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
        
    }
    
    public boolean check(String strA, String strB){
        int cnt = 0;
        for(int i=0; i<strA.length(); i++){
            if(strA.charAt(i) == strB.charAt(i)) cnt++;
        }
        if((strA.length() - 1) == cnt) return true;
        else return false;
    }
}