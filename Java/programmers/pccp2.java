class Solution {
  static int[][] gasMap;
  static int[] gasArr;
  static int minX;
  static int maxX;
  static int partialSum;
  
  static int[] dirX = {-1, 0, 1, 0};
  static int[] dirY = {0, -1, 0, 1};
  
  
  public int solution(int[][] land) {
      int answer = 0;
      gasArr = new int[land[0].length];
      gasMap = land;
      
      for(int i = 0; i < gasArr.length; i++) {
          mine(i);
      }

      for(int i = 0; i < gasArr.length; i++) {
        if(gasArr[i] > answer) answer = gasArr[i];
      }
      return answer;
  }
  
  public void mine(int index) {

      
      for(int i = 0; i < gasMap.length; i++) {
          if(gasMap[i][index] == 1) {
            minX = index;
            maxX = index;
            partialSum = 0;
            mineHelper(i, index);
            for(int j = minX; j <= maxX; j++) {
              gasArr[j] += partialSum;
            }
          }
      }
  }
  
  public void mineHelper(int y, int x) {
      if(y < 0 || y >= gasMap.length || x < 0 || x >= gasMap[0].length) return;
      if(gasMap[y][x] != 1) return;
      
      partialSum++;
      if(minX > x) minX = x;
      if(maxX < x) maxX = x;
      gasMap[y][x] = -1;

      
      for(int i = 0; i < dirX.length; i++) {
          mineHelper(y + dirY[i], x + dirX[i]);
      }
  }
}
