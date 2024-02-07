import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int P;
    static HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            map.put(i, new Stack<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineN = Integer.parseInt(st.nextToken());
            int platN = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = map.get(lineN);


            while(true) {
                if(stack.isEmpty()) {
                    answer++;
                    stack.push(platN);
                    break;
                }
                if(stack.peek() > platN) {
                    answer++;
                    stack.pop();
                } else if(stack.peek() < platN) {
                    answer++;
                    stack.push(platN);
                    break;
                } else {
                    break;
                }
            }
        }


        bw.write(answer + "");
        bw.flush();
    }

}