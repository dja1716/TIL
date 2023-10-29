import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int[] coinKinds = new int[sc.nextInt()];
        int total = sc.nextInt();
        int count = 0;
        
        for(int i = coinKinds.length - 1; i >= 0; i--)  {
            coinKinds[i] = sc.nextInt();
        }
        
        int i = 0;
        
        while(i < coinKinds.length) {
            int coinNum = total / coinKinds[i];
            
            if(coinNum > 0) {
                total %= coinKinds[i];
                count += coinNum;
                if(total == 0) {
                    break;
                }
            }
            i++; 
        }
        System.out.println(count);
    }
}
