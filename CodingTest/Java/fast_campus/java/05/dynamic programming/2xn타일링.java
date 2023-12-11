import java.util.*;

class Main {
    static int n;
    static int mod = 10007;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int[] dArr = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                dArr[i] = 1;
            } else if(i == 2) {
                dArr[i] = 2;
            } else {
                dArr[i] = (dArr[i-1] + dArr[i-2]) % mod;
            }
        }
        
        System.out.println(dArr[n]);
    }
}
