package Java.coding_test.programmers.대표유형.스택큐.프로세스;

import java.util.*;
import java.io.*;

class Solution {
    static class Job {
        boolean check;
        int priority;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> q = new LinkedList<>();
        List<Integer> p = new ArrayList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            p.add(priorities[i]);
            boolean check = false;
            if(i == location) {
                check = true;
            }
            Job j = new Job();
            j.check = check;
            j.priority = priorities[i];
            q.add(j);
        }
        
        Collections.sort(p, (o1, o2) -> {
            return o2 - o1;
        });
        int idx = 0;
        while(!q.isEmpty()) {
            Job j = q.poll();
            if(p.get(idx) == j.priority) {
                answer++;
                idx++;
                if(j.check) {
                    break;
                }
            } else {
                q.add(j);
            }
        }
        return answer;
    }
}