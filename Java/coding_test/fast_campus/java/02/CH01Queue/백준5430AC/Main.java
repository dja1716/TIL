import java.util.*;
import java.io.*;

public class Main {


    static int N;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] commands = st.nextToken().toCharArray();
            st = new StringTokenizer(br.readLine());
            int arrSize = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder(br.readLine());
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            String[] arr = new String(sb).split(",");
            Deque<Integer> dq = new LinkedList<>();
            for(int i = 0; i < arrSize; i++) {
                dq.add(Integer.parseInt(arr[i]));
            }
            boolean dir = true;
            boolean err = false;
            int idx = 0;
            while(idx < commands.length) {
                char command = commands[idx++];

                if(command == 'R') {
                    dir = !dir;
                } else {
                    if(dq.isEmpty()) {
                        err = true;
                        break;
                    }
                    if(dir) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
            if(err) {
                bw.write("error\n");
            } else {
                sb = new StringBuilder();
                sb.append("[");
                if(!dq.isEmpty()) {
                    if(dir) {
                        while(!dq.isEmpty()) {
                            sb.append(dq.pollFirst());
                            sb.append(",");
                        }
                    } else {
                        while(!dq.isEmpty()) {
                            sb.append(dq.pollLast());
                            sb.append(",");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]\n");
                bw.write(new String(sb));
            }
        }

        bw.flush();
    }

}