package Java.coding_test.programmers.대표유형.BFS_DFS.단어변환;

import java.util.*;

class Solution {
    
    static class Word {
        String word;
        int count;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = BFS(begin, target, words);
        
        return answer;
    }
    
    public int BFS(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Word start = new Word();
        start.word = begin;
        start.count = 0;
        Queue<Word> q = new LinkedList<>();
        q.add(start);
        
        
        while(!q.isEmpty()) {
            Word w = q.poll();
            if(w.word.equals(target)) {
                return w.count;
            }
            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                int diff = 0;
                boolean condition = true;
                for(int j = 0; j < w.word.length(); j++) {
                    if(w.word.charAt(j) != words[i].charAt(j)) {
                        ++diff;
                        if(diff > 1) {
                            condition = false;
                            break;
                        }
                    }
                }
                if(condition) {
                    visited[i] = true;
                    Word nw = new Word();
                    nw.word = words[i];
                    nw.count = w.count + 1;
                    q.add(nw);
                }
            }
        }
        return 0;
    }
}