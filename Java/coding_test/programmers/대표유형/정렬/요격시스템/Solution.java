package Java.coding_test.programmers.대표유형.정렬.요격시스템;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int end = targets[0][1];
        answer++;
        
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] < end) continue;
            answer++;
            end = targets[i][1];
        }
        return answer;
    }
}