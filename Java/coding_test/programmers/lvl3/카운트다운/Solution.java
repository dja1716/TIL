package Java.coding_test.programmers.lvl3.카운트다운;

import java.util.*;

class Solution {
    
    static int[][] dp;
    static int target;
    static List<Integer> l1 = new ArrayList<>();
    static List<Integer> l2 = new ArrayList<>();
    // 1 ~ 20 싱글 더블 트리플 불
    // 0 점 먼저 / 싱글, 불 더 많이 던진 선수, 모두 같으면 선공인 선수가 승리
    // 최선의 경우
    // [던진 다트 수, 싱글 or 불]
    // 1 <= target <= 100000
    public int[] solution(int t) {
        int[] answer = {};
        target = t;
        dp = new int[target+1][2];
        
        // 0일 때를 넣어주기
        for(int i = 1; i <= 20; i++) {
            l1.add(i);
            l2.add(i * 2);
            l2.add(i * 3);
        }
        l1.add(50);
        
        for(int i = 0; i < l1.size(); i++) {
            if(l1.get(i) > target) continue;
            dp[l1.get(i)][0] = 1;
            dp[l1.get(i)][1] = 1;
        }
        
        for(int i = 0; i < l2.size(); i++) {
            if(l2.get(i) > target) continue;
            dp[l2.get(i)][0] = 1;
        }
        
        
        for(int i = 1; i <= target; i++) {
            if(dp[i][0] == 0) continue;
            for(int single : l1) {
                if(single + i <= target) {
                    int tries = dp[i][0] + 1;
                    int singles = dp[i][1] + 1;
                    int[] temp = {tries, singles};
                    if(check(temp, dp[single + i])) {
                        dp[single + i][0] = temp[0];
                        dp[single + i][1] = temp[1];
                    }
                }
            }
            for(int normal : l2) {
                if(normal + i <= target) {
                    int tries = dp[i][0] + 1;
                    int singles = dp[i][1];
                    int[] temp = {tries, singles};
                    if(check(temp, dp[normal + i])) {
                        dp[normal + i][0] = temp[0];
                        dp[normal + i][1] = temp[1];
                    }
                }
            }
        }
        
        return dp[target];
    }
    
    boolean check(int[] a1, int[] a2) {
        if(a2[0] == 0) return true;
        if(a1[0] == a2[0]) {
            return a1[1] >= a2[1];
        }
        return a1[0] < a2[0];
    }

}