package coding_test;
import java.util.Scanner;

public class 숫자의합Pro {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    // 입력값을 String형 변수 sNum에 저장 후 char[]형 변수로 변환하기
    String sNum = sc.next();
    char[] cNum = sNum.toCharArray();
    sc.close();
    int sum = 0;

    for(int i = 0; i < n; i++) {
      sum += cNum[i] - '0';
    }
    System.out.print(sum);
  }
}
