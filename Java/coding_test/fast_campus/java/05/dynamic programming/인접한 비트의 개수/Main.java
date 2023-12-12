import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int[] steps = new int[n+1];
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            steps[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                d1[i] = steps[i];
                d2[i] = steps[i];
                continue;
            }
            d1[i] = Math.max(d1[i-2], d2[i-2]) + steps[i];
            d2[i] = d1[i-1] + steps[i];
        }
        
        System.out.println(Math.max(d1[n], d2[n]));
    }
}
