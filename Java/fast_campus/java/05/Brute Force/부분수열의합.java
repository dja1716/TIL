import java.util.*;

public class Main {
    static long target;
    static long sum = 0;
    static long count = 0;
    static boolean[] selection;
    static int N;
    static long[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextLong();
        arr = new long[N];
        selection = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        
        recursion(0);
        if(target == 0) {
            count--;
        }
        System.out.println(count);
    }
    
    public static void recursion(int k) {
        if(k >= N) {
            if(sum == target) {
                count++;
                
            }
            return;
        };
        
        // select
        selection[k] = true;
        sum += arr[k];
        
        recursion(k+1);
        
        selection[k] = false;
        sum -= arr[k];
        
        
        // not select
        recursion(k+1);
    }
}
