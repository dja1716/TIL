package Java.coding_test.programmers.대표유형.정렬.인사고과;
import java.util.*;


class Solution {
    int n, m;
    public int solution(int[][] scores) {
        int answer = 1;
        n = scores[0][0];
        m = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0]; 
        });
        
        int max = scores[0][1];
        
        for(int[] s : scores) {
            if(s[1] < max) {
                if(s[0] == n && s[1] == m) {
                    return -1;
                }
                s[0] = -1;
                s[1] = -1;
            }
            max = Math.max(max, s[1]);
        }
        
        Arrays.sort(scores, (s1, s2) -> {
            return (s2[0] + s2[1]) - (s1[0] + s1[1]);
        });
        
        for(int i = 0; i < scores.length; i++) {
            if(scores[i][0] + scores[i][1] > n + m) {
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}