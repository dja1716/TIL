import java.util.*;
import java.io.*;

public class Main {

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        boolean possible = true;
        for (char value : input) {
            if (value == '(' || value == '[') {
                stack.push(value);
            } else if (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '(' && value != ')' || c == '[' && value != ']') {
                    possible = false;
                    break;
                }
            } else {
                possible = false;
                break;
            }
        }
        if(!stack.isEmpty()) {
            possible = false;
        }
        if(!possible) {
            bw.write(0 + "");
            bw.flush();
            return;
        }

        bw.write(compute(0, input.length - 1) + "");
        bw.flush();
    }
    static int compute(int start, int end) {
        int idx = start;
        Stack<Character> stack = new Stack<>();

        if(start >= end) {
            return 0;
        }

        while(true) {
            if(input[idx] == '(' || input[idx] == '[') {
                stack.push(input[idx]);
            } else {
                stack.pop();
            }
            if(stack.isEmpty()) {
                break;
            }

            idx++;
        }



        if(start == idx - 1) {
            int result = input[start] == '[' ? 3 : 2;
            return result + compute(idx + 1, end);
        }

        if(input[start] == '[') {
            return 3 * compute(start + 1, idx - 1) + compute(idx + 1, end);
        }
        return 2 * compute(start + 1, idx - 1) + compute(idx + 1, end);

    }
}