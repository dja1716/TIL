import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    static int N;

    static Stack<Pair> stack = new Stack<>();
    static int[] answer;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        answer = new int[N];
        input = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty()) {
                Pair curP = stack.peek();
                if(curP.first < input[i]) {
                    answer[curP.second] = input[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Pair(input[i], i));
        }
        while(!stack.isEmpty()) {
            Pair curP = stack.pop();

            answer[curP.second] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(new String(sb));
        bw.flush();
    }

}