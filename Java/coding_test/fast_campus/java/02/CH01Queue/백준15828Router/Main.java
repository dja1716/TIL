import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        while(true) {
            st = new StringTokenizer(br.readLine());
            int inputN = Integer.parseInt(st.nextToken());

            if(inputN == -1) {
                break;
            } else if(inputN == 0) {
                q.poll();
            } else {
                if(q.size() < N) {
                    q.add(inputN);
                }
            }
        }

        if(q.isEmpty()) {
            sb.append("empty");
        } else {
            while(!q.isEmpty()) {
                sb.append(q.poll());
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        
        bw.write(new String(sb));
        bw.flush();
    }
}