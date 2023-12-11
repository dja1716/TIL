import java.util.*;

public class 에너그램Pro {
    static int answer = 0;
    public static int[] count(String s) {
        int[] result = new int['z' - 'a' + 1];
        
        for(int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();
        
        compute(A, B);
        
        System.out.println(answer);
        
    }
    
    public static void compute(String A, String B) {
        int[] countA = count(A);
        int[] countB = count(B);
        
        for(int i = 0; i < countA.length; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }
    }
}
