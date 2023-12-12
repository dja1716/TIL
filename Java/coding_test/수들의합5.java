package coding_test;
import java.util.Scanner;

public class 수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        
        long count = 1;
        long start = 1;
        long end = 1;
        long sum = 1;
        
        while(end < n) {
            if(sum == n) {
                count++;
                end++;
                sum += end;
            } else if(sum < n) {
                end++;
                sum += end;
            } else if(sum > n) {
                sum -= start;
                start++;
            }
        }
        
        System.out.println(count);
    }
}
