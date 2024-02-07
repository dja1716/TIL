import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Boolean> answers = new ArrayList<>();

        while(true) {

            String input = br.readLine();

            if(input.equals(".")) {
                break;
            }
            char[] arr = input.toCharArray();

            Stack<Character> stack = new Stack<>();
            boolean answer = true;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '[' || arr[i] == '(') {
                    stack.push(arr[i]);
                }
                if(arr[i] == ')' || arr[i] == ']') {
                    if(stack.isEmpty()) {
                        answer = false;
                        break;
                    }
                    char c = stack.pop();
                    if(arr[i] == ')' && c != '(' || arr[i] == ']' && c != '[') {
                        answer = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) {
                answer = false;
            }
            answers.add(answer);
        }
        for(boolean b : answers) {
            bw.write(b ? "yes\n" : "no\n");
        }

        bw.flush();
    }

}