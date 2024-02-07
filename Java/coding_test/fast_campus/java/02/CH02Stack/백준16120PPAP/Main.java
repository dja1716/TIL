import java.util.*;
import java.io.*;

public class Main {

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean ans = true;

        input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int idx = 0;

        while(idx < input.length) {
            if(input[idx] == 'A') {
                if(idx == input.length - 1) {
                    ans = false;
                    break;
                }
                if(input[idx+1] == 'P') {
                    if(stack.size() >= 2) {
                        stack.pop();
                        idx += 2;
                    } else {
                        ans = false;
                        break;
                    }
                } else {
                    ans = false;
                    break;
                }
            } else {
                stack.push('P');
                idx++;
            }
        }
        bw.write(ans && stack.size() == 1 ? "PPAP" : "NP");
        bw.flush();
    }

}