package coding_test.백준;
import java.util.*;

public class 스택수열HARD {
    public static void main(String[] args) {
        boolean possible = true;
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 1 input
        int n = sc.nextInt();
        int next = 1;
        int[] targets = new int[n];


        for(int i = 0; i < n; i++) {
            targets[i] = sc.nextInt();
        }
        // setting stack
        stack.push(next++);
        sb.append("+\n");
        // execution
        for(int i = 0; i < n; i++) {
            int target = targets[i];
            if(stack.isEmpty() || target > stack.peek()) {
                while(true) {
                    stack.push(next);
                    sb.append("+\n");
                    next++;
                  
                    if(stack.peek() == target) {
                        stack.pop();
                        sb.append("-\n");
                        break;
                    }

                    if(next > target) {
                        possible = false;
                        break;
                    }
                }
            } else if(target <=stack.peek()) {
                while(true) {
                    if(stack.isEmpty() || target > stack.peek()) {
                        possible = false;
                        break;
                    }
                    int temp = stack.pop();
                    sb.append("-\n");
                    if(temp == target) {
                        break;
                    }
                }
            }
            if(!possible) {
                break;
            }
        }


        // print
        if(possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}
