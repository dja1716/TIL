import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        String B = sc.nextLine();
        
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int answer = 0;
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        int a = 0;
        int b = 0;
        
        while(a < arrA.length && b < arrB.length) {
            if(arrA[a] == arrB[b]) {
                a++;
                b++;
            } else if(arrA[a] < arrB[b]) {
                answer++;
                a++;
            } else {
                answer++;
                b++;
            }
        }
        
        answer += arrA.length - a;
        answer += arrB.length - b;
        
        System.out.println(answer);
    }
}
