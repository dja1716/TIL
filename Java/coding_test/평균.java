package coding_test;
import java.io.*;

public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        String[] scores = br.readLine().split(" ");
        long totalScore = 0;
        long maxScore = 0;
        for (String score : scores) {
            long scoreNum = Long.parseLong(score);
            totalScore += Long.parseLong(score);
            if(scoreNum > maxScore) {
                maxScore = scoreNum;
            }
        }

        double avg = (double) totalScore / n / maxScore * 100;

      System.out.println(String.format("%f", avg));
    }
}
