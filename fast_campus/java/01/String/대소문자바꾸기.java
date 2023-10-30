import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.nextLine();
        char[] answer = s.toCharArray();
        
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] >= 'a') {
                answer[i] = (char) (answer[i] - 'a' + 'A');
            } else {
                answer[i] = (char) (answer[i] + 'a' - 'A');
            }
        }
        
        System.out.println(String.valueOf(answer));
    }
}
