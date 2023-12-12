import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int totalScore = 0;
    int maxScore = 0;
    
    for(int i = 0; i < n; i++) {
      int score = sc.nextInt();

      if(score > maxScore) {
        maxScore = score;
      }
      totalScore += score;
    }
    System.out.print(totalScore / maxScore * 100.0 / n);
  }
}
