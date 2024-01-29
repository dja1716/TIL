import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[8];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr[0] == 1) {
            boolean asc = true;
            for(int i = 1; i < 8; i++) {
                if(arr[i] < arr[i-1]) {
                    asc = false;
                    bw.write("mixed");
                    break;
                }
            }
            if(asc) bw.write("ascending");
        } else if(arr[0] == 8) {
            boolean desc = true;
            for(int i = 1; i < 8; i++) {
                if(arr[i] > arr[i - 1]) {
                    desc = false;
                    bw.write("mixed");
                    break;
                }
            }
            if(desc) bw.write("descending");
        }
        bw.flush();
    }
}