import java.util.*;
import java.io.*;


public class Main {


    static char[] input;
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean isComplete = false;
    static boolean[] used = new boolean[51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        input = st.nextToken().toCharArray();

        solve(0);
        bw.write(new String(sb));
        bw.flush();

    }

    public static void solve(int idx) {
        if(isComplete) return;
        if(idx == input.length) {
            boolean isAnswer = true;
            int tempIdx = 1;
            for(; tempIdx < used.length; tempIdx++) {
                if(!used[tempIdx]) {
                    break;
                }
            }
            for(; tempIdx < used.length; tempIdx++) {
                if(used[tempIdx]) {
                    isAnswer = false;
                    break;
                }
            }
            if(isAnswer) {
                for(int i = 0; i < answer.size(); i++) {
                    sb.append(answer.get(i));
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length()-1);
                isComplete = true;
            }
            return;
        }

        int a = input[idx] - '0';
        if(a <= 50 && !used[a]) {
            answer.add(a);
            used[a] = true;
            solve(idx + 1);
            used[a] = false;
            answer.remove(answer.size()-1);
        }


        if(idx + 1 < input.length) {
            int b = input[idx+1] - '0';
            int temp = a * 10 + b;
            if(temp <= 50 && !used[temp]) {
                answer.add(temp);
                used[temp] = true;
                solve(idx + 2);
                used[temp] = false;
                answer.remove(answer.size()-1);
            }

        }
    }

}