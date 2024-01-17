import java.io.*;
import java.util.*;

public class Main {
    static int N, B, W;
    static boolean[] path;
    static int bCount = 0;
    static int wCount = 0;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String pathStr = st.nextToken();
        path = new boolean[pathStr.length()];

        for(int i = 0; i < pathStr.length(); i++) {
            if(pathStr.charAt(i) == 'W') {
                path[i] = true;
            } else {
                path[i] = false;
            }
        }
        int startIdx = 0;
        int endIdx = 0;


        while(startIdx < N && endIdx < N) {
            if(bCount > B) {
                subtract(startIdx);
                check();
                startIdx++;
            } else {
                add(endIdx);
                check();
                endIdx++;
            }
        }
        bw.write(answer + "");
        bw.flush();

    }

    static void add(int i) {
        if(path[i]) {
            wCount++;
        } else {
            bCount++;
        }
    }
    static void subtract(int i) {
        if(path[i]) {
            wCount--;
        } else {
            bCount--;
        }
    }

    static void check() {
        if(wCount >= W && bCount <= B) {
            answer = Math.max(answer, wCount + bCount);
        }
    }
}
