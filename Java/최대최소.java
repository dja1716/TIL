import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        
        
        for(int i = 0; i < N; i++) {
            long temp = sc.nextLong();
            if(temp > max) {
                max = temp;
            }
            
            if(temp < min) {
                min = temp;
            }
        }
        System.out.println(min + " " + max);
    }
}
