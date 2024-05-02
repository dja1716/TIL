package Java.coding_test.programmers.대표유형.동적계획법.에어컨;

import java.util.*;

class Solution {
    int[][] dp;
    public int solution(int temp, int t1, int t2, int a, int b, int[] onboard) {
        int answer = Integer.MAX_VALUE;
        t1 += 10;
        t2 += 10;
        temp += 10;
        dp = new int[onboard.length][51];
        
        
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][temp] = 0;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(onboard[i] == 1 && (j > t2 || j < t1)) continue;
                
                if(dp[i-1][j] != Integer.MAX_VALUE) dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + b);
                if(j - 1 >= 0 && dp[i-1][j-1] != Integer.MAX_VALUE) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + a);
                if(j + 1 <= 50 && dp[i-1][j+1] != Integer.MAX_VALUE) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + a);
                if(temp == j) {
                    // 아래 위로 그리고 같게
                    if(j + 1 <= 50) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                    if(j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                } else if(temp < j) {
                    // 위에서
                    if(j + 1 <= 50) dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                } else {
                    if(j - 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
            }
        }
        
        for(int i = 0; i <= dp[0].length; i++) {
            answer = Math.min(answer, dp[dp.length-1][i]);
        }
        return answer;
    }
}