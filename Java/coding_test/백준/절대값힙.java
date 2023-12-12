package coding_test.백준;
import java.util.*;

public class 절대값힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(); // 1, 2 ,3, 4
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>(Comparator.reverseOrder()); // 4, 3, 2, 1
        
        // get n
        int n = sc.nextInt();
        
        
        
        // computation
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            
            if(input == 0) {
                if(negativeQ.size() == 0 && positiveQ.size() == 0) {
                    sb.append("0\n");
                } else if(negativeQ.size() == 0) {
                    sb.append(positiveQ.poll() + "\n");
                } else if(positiveQ.size() == 0) {
                    sb.append(negativeQ.poll() + "\n");
                } else {
                    // compare
                    int negN = negativeQ.peek();
                    int posN = positiveQ.peek();
                
                    if(negN * -1 <= posN) {
                        sb.append(negN + "\n");
                        negativeQ.poll();
                    } else {
                        sb.append(posN + "\n");
                        positiveQ.poll();
                    }
                }

            } else if(input > 0) {
                positiveQ.add(input);
            } else {
                negativeQ.add(input);
            } 
        }
        System.out.print(sb);
        sc.close();
    }
}
