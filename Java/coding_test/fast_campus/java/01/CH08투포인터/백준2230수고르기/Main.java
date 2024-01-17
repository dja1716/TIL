import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Integer[] arr;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Integer[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Integer temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }

        Arrays.sort(arr);

        int firstIdx = 0;
        int secondIdx = 1;

        while(firstIdx < N && secondIdx < N) {
            int diff = arr[secondIdx] - arr[firstIdx];
            if(diff >= M) {
                answer = Math.min(diff, answer);
                firstIdx++;
            } else {
                secondIdx++;
            }
        }


        bw.write(answer + "");
        bw.flush();

    }


}
