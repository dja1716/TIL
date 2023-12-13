import java.util.*;
import java.io.*;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            int[] children = new int[20];
            st = new StringTokenizer(br.readLine());
            int caseN = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 20; j++) {
                children[j] = Integer.parseInt(st.nextToken());
            }
            compute(caseN, children);
        }
    }

    public static void compute(int caseN, int[] children) {
        int count = 0;

        for(int i = 1; i < 20; i++) {
            if(children[i] > children[i-1]) continue;

            for(int j = i - 1; j >= 0; j--) {
                if(children[i] > children[j]) {
                    int temp = children[j+1];
                    int end = children[i];
                    for(int k = j+2; k <= i; k++) {
                        int temp2 = children[k];
                        children[k] = temp;
                        temp = temp2;
                        count++;
                    }
                    children[j+1] = end;
                    break;
                } else if(j == 0) {
                    int temp = children[0];
                    int end = children[i];
                    for(int k = j+1; k <= i; k++) {
                        int temp2 = children[k];
                        children[k] = temp;
                        temp = temp2;
                        count++;
                    }
                    children[0] = end;
                }
            }
        }
        System.out.println(caseN + " " + count);
    } 
}