import java.util.*;
import java.io.*;

public class Main {

    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {

            input = br.readLine().toCharArray();
            Deque<Character> leftDQ = new LinkedList<>();
            Deque<Character> rightDQ = new LinkedList<>();

            for(char c : input) {
                if(c == '<') {
                    if(!leftDQ.isEmpty()) {
                        rightDQ.addFirst(leftDQ.removeLast());
                    }
                } else if(c == '>') {
                    if(!rightDQ.isEmpty()) {
                        leftDQ.addLast(rightDQ.removeFirst());
                    }
                } else if(c == '-') {
                    if(!leftDQ.isEmpty()) {
                        leftDQ.removeLast();
                    }
                } else {
                    leftDQ.addLast(c);
                }
            }

            while(!leftDQ.isEmpty()) {
                sb.append(leftDQ.removeFirst());
            }

            while(!rightDQ.isEmpty()) {
                sb.append(rightDQ.removeFirst());
            }

            sb.append('\n');


        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(new String(sb));
        bw.flush();
    }

}