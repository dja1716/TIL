import java.util.*;
import java.io.*;

class Main {
    static int max = Integer.MIN_VALUE;
    static int[] answerArr;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        answerArr = new int[n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            
            int temp = Integer.parseInt(st.nextToken());
            
            if(temp > max) {
                max = temp;
            }
            
            answerArr[i] = temp;
        }
        
        int[] dArr = new int[max + 1];
        
        for(int i = 1; i <= max; i++) {
            if(i == 1) {
                dArr[i] = 1;
            } else if(i == 2) {
                dArr[i] = 2;
            } else if(i == 3) {
                dArr[i] = 4;
            } else {
                dArr[i] = dArr[i-1] + dArr[i-2] + dArr[i-3];
            }
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(dArr[answerArr[i]]);
        }
    }
}
