import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[] arr;
    static boolean isComplete = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        solve(0);
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        bw.write(new String(sb));
        bw.flush();

    }


    public static void solve(int idx) {


        if(idx == N) {
            isComplete = true;
            return;
        }

        int length = idx + 1;
        for(int k = 1; k <= 3; k++) {
            boolean isPossible = true;
            if(isComplete) return;
            arr[idx] = k;
            for(int i = 1; i <= length / 2; i++) {
                boolean itB = true;
                for(int j = 0; j < i; j++) {

                    if(arr[idx - j] != arr[idx - j - i]) {
                        itB = false;
                        break;
                    }
                }
                if(itB) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                solve(idx+1);
            }
        }

    }
}