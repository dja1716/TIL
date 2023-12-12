package coding_test;
import java.util.Scanner;

public class 구간합구하기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] sumArr = new long[N];
        long total = 0;
        long[] answers = new long[M];
        for(int i = 0; i < N; i++) {
            long temp = sc.nextLong();
            total += temp;
            sumArr[i] = total;
        }

        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            long answer = sumArr[end - 1] - (start != 1 ? sumArr[start - 2] : 0);
            answers[i] = answer;
        }
      for(int i = 0; i < M; i++) {
        System.out.println(answers[i]);
      }
      sc.close();
    }
}
