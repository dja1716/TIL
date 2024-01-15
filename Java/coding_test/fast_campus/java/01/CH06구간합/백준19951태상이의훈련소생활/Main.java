import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] delta;
    static int[] accDelta;



    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        delta = new int[N + 2];
        accDelta = new int[N + 2];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            delta[start] += amount;
            delta[end + 1] -= amount; 
        }

        for(int i = 1; i < delta.length; i++) {
            accDelta[i] = delta[i] + accDelta[i-1];
        }

        for(int i = 1; i < N; i++) {
            bw.write((accDelta[i] + arr[i]) + " ");
        }
        bw.write((accDelta[N] + arr[N]) + "");

        bw.flush();
    }


}
