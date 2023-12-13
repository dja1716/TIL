import java.util.*;
import java.io.*;

public class Main {
    static boolean[] arr = new boolean[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        String[] arrS = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(arrS[i]);
            arr[temp] = true;
        }
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int untill = target / 2;
        if(untill * 2 == target) {
            untill--;
        }
        int answer = 0;

        for(int i = 1; i <= untill; i++) {
            int counterPart = target - i;
            if(counterPart <= 1000000 && arr[i] && arr[target - i]) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
