package coding_test.백준;
import java.util.*;
import java.io.*;

public class 수맞추기 {
    static int[] arr;
    static StringBuilder answer;
    static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        
        answer = new StringBuilder();
        
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            found = false;
            binarySearch(Integer.parseInt(st.nextToken()), 0, N-1);
            if(found) {
                answer.append("1\n");
            } else {
                answer.append("0\n");
            }
        }
        System.out.println(answer);
    }
    
    static void binarySearch(int val, int minPos, int maxPos) {
        if(found) return;
        int mid = (maxPos + minPos) / 2;
        if(arr[mid] == val) {
            found = true;
            return;
        }
        
        if(minPos > maxPos) return;
        
        if(arr[mid] < val) {
            binarySearch(val, mid + 1, maxPos);
        } else {
            binarySearch(val, minPos, mid - 1);
        }
    }
    
}
