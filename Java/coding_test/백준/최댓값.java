package coding_test.백준;
import java.util.Scanner;

public class 최댓값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maxValue = 0;
        int order =0;
        
        for(int i = 0; i < 9; i++) {
            int temp = sc.nextInt();
            if(temp > maxValue) {
                maxValue = temp;
                order = i + 1;
            }
        }
        System.out.println(maxValue);
        System.out.println(order);
    }
}
