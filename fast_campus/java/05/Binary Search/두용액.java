import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int c1;
    static int c2;
    static int total = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        input();
        process();
        output();
    }
    
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
    
    public static void process() {

        
        for(int i = 0; i < N - 1; i++) {
            int tempIndex = binarySearch(i+1, N - 1, - arr[i]);
            
            if(tempIndex <= N - 1 && Math.abs(arr[i] + arr[tempIndex]) < total) {
                total = Math.abs(arr[i] + arr[tempIndex]);
                c1 = arr[i];
                c2 = arr[tempIndex];
            }
            if(tempIndex > i + 1 && Math.abs(arr[i] + arr[tempIndex - 1]) < total) {
                total = Math.abs(arr[i] + arr[tempIndex - 1]);
                c1 = arr[i];
                c2 = arr[tempIndex -1];
            }
        }
    }
    
    public static int binarySearch(int start, int end, int target) {
        int mid = (start + end) / 2;

        int cur = end;
        while(start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] >= target) {
                cur = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return cur;
    }
    
    public static void output() {
        System.out.println(c1 + " " + c2);
    }
}
