package 공유기설치;
import java.util.*;
import java.io.*;

public class Main {
    static int C;
    static int N;
    static int[] axis;
    static int max = 0;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        getInput();
        
        process();
        
    }
    
    public static void process() {
        Arrays.sort(axis);
        int result = 0;
        int left = 0;
        int right = max;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(valid(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
    
    public static boolean valid(int length) {
        int count = 1;
        int lastPos = 0;
        
        for(int i = 1; i < N; i++) {
            if(axis[i] - axis[lastPos] >= length) {
                count++;
                lastPos = i;
            }
        }
        
        return count >= C;
    }
    
    public static void getInput() throws IOException {
        // get input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        axis = new int[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            axis[i] = Integer.parseInt(st.nextToken());
            if(axis[i] > max) {
                max = axis[i];
            }
        }
    }
}
