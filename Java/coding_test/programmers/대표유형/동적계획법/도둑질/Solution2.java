package Java.coding_test.programmers.대표유형.동적계획법.도둑질;

class Solution {
  int[][] dp;
  public int solution(int[] money) {
      int answer = 0;
      dp = new int[2][money.length];
      // 첫 집 yes
      dp[0][0] = money[0];
      dp[0][1] = money[0];
      // 첫 집 no
      dp[1][0] = 0;
      dp[1][1] = money[1];
      
      for(int i = 2; i < money.length; i++) {
          dp[0][i] = Math.max(dp[0][i-2] + money[i], dp[0][i-1]);
          dp[1][i] = Math.max(dp[1][i-2] + money[i], dp[1][i-1]);
      }
      
      answer = Math.max(dp[1][money.length-1], dp[0][money.length-2]);
      
      return answer;
  }
}