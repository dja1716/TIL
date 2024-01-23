import java.util.*;
import java.io.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answers = new LinkedList<>();
        int counter = 0;

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        while(!q.isEmpty()) {
            counter++;
            if(counter == K) {
                counter = 0;
                int out = q.poll();
                answers.add(out);
            } else {
                q.add(q.poll());
            }
        }
        bw.write("<");
        while(!answers.isEmpty()) {
            bw.write(answers.poll() + "");
            if(!answers.isEmpty()) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
    }
}