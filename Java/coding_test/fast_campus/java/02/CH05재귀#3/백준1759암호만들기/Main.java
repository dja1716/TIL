import java.util.*;
import java.io.*;


public class Main {
    static int L, C;
    static String[] input;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = br.readLine().split(" ");

        Arrays.sort(input);

        recursion(new StringBuilder(), 0, 0, 0);

        bw.write(new String(sb));
        bw.flush();

    }
    static void recursion(StringBuilder pwd, int idx, int vCnt, int cCnt) {
        if(pwd.length() == L && vCnt >= 1 && cCnt >= 2) {
            sb.append(pwd);
            sb.append('\n');
            return;
        }
        if(idx == C) return;

        String[] V = {"a", "e", "i", "o", "u"};

        for(String v : V) {
            if(v.equals(input[idx])) {
                pwd.append(input[idx]);
                recursion(pwd, idx+1, vCnt+1, cCnt);
                pwd.deleteCharAt(pwd.length()-1);
                recursion(pwd, idx+1, vCnt, cCnt);
                return;
            }
        }


        pwd.append(input[idx]);
        recursion(pwd, idx+1, vCnt, cCnt+1);
        pwd.deleteCharAt(pwd.length()-1);
        recursion(pwd, idx+1, vCnt, cCnt);

    }
}