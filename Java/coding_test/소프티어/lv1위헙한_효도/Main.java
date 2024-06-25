package Java.coding_test.소프티어.lv1위헙한_효도;

import java.io.*;
import java.util.*;

public class Main {
    static int A, B, D;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        answer += D * 2;

        if(D / A != 0) {
            if(D % A == 0) {
                answer += (D / A - 1) * B;
            } else {
                answer += D / A * B;
            }
        }

        if(D / B != 0) {
            if(D % B == 0) {
                answer += (D / B - 1) * A;
            } else {
                answer += D / B * A;
            }
        }
        
        System.out.println(answer);
    }
}
