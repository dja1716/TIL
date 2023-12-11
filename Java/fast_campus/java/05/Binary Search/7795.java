import java.util.*;

public class Main {
    static int[] A;
    static int[] B;
    static int N;
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
            pro();
            
        }
    }
    
    public static void pro() {
        A = new int[sc.nextInt()];
        B = new int[sc.nextInt()];
        int result = 0;
        
        for(int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        
        for(int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        
        while(aIndex < A.length && bIndex < B.length) {
            
            while(aIndex < A.length) {
                if(B[bIndex] < A[aIndex]) {
                    result += A.length - aIndex;
                    break;
                }
                aIndex++;
            }
            bIndex++; 
        }
        System.out.println(result);
    }
}
