import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int cDis = 0;
    static int totalDis = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            totalDis += temp;
        }

        int firstIdx = 0;
        int secondIdx = 1;
        cDis = arr[0];


        while(firstIdx < N && secondIdx < N) {

            int ccDis = totalDis - cDis;

            if(ccDis > cDis) {
                answer = Math.max(cDis, answer);
                cDis += arr[secondIdx];
                secondIdx++;
            } else if (ccDis < cDis) {
                answer = Math.max(answer, ccDis);
                cDis -= arr[firstIdx];
                firstIdx++;
            } else {
                answer = cDis;
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();

    }


}
