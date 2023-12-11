import java.util.*;

public class 연산자끼워넣기 {
    static int N;
    static int[] choices;
    static int[] ops = new int[4];
    static int[] numbers;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        numbers = new int[N];
        choices = new int[N-1];
        
        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        
        for(int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt();
        }
        recFunc(0);
        
        
        System.out.println(max);
        System.out.println(min);
        
    }
    
    public static void recFunc(int k) {
        if(k >= N - 1) {
            calculate();
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(ops[i] > 0) {
                ops[i]--;
                choices[k] = i;
                recFunc(k + 1);
                choices[k] = -1;
                
                ops[i]++;
            }
        }
    }
    
    public static void calculate() {
        long result = numbers[0];
        for(int i = 0; i < N - 1; i++) {
            if(choices[i] == 0) {
                result += numbers[i+1];
            } else if (choices[i] == 1) {
                result -= numbers[i+1] ;
            } else if (choices[i] == 2) {
                result *= numbers[i+1];
            } else if (choices[i] == 3) {
                result /= numbers[i+1];
            }
        }
        if(result > max) max = result;
        if(result < min) min = result;
    }
    
}
