package Java.coding_test.programmers.대표유형.동적계획법.도둑질;

class Solution {
  int[][] dp;
  public int solution(int[] money) {
      int answer = 0;
      dp = new int[money.length][2];
      // 첫집 턴경우
      dp[2][0] = money[0] + money[2];
      dp[2][1] = money[0];
      
      for(int i = 3; i < money.length; i++) {
          dp[i][0] = dp[i-1][1] + money[i];
          dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
      }
      answer = dp[money.length-1][1];
      
      // 첫집 안턴경우
      dp[1][0] = money[1];
      for(int i = 2; i < money.length; i++) {
          dp[i][0] = dp[i-1][1] + money[i];
          dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
      }
      answer = Math.max(answer, Math.max(dp[money.length-1][0], dp[money.length-1][1]));
      return answer;
  }
}