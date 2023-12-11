import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        String B = sc.nextLine();
        
        int i = 0;
        int answer = 0;
        while(i < A.length()) {
            int index = A.indexOf(B, i);
            if(index == -1) break;
            
            i = index + B.length();
            answer++;
        }
        System.out.println(answer);
    }
}
