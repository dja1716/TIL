package coding_test;
import java.io.*;
import java.util.*;

public class 주몽better {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        long target = Long.parseLong(st.nextToken());
        int[] materials = new int[n];
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        Arrays.sort(materials);
        
        int start = 0;
        int end = n - 1;
        while(start < end) {
            int result = materials[start] + materials[end];
            if(result == target) {
                count++;
                start++;
                end--;
            } else if(result < target) {
                start++;
            } else if(result > target) {
                end--;
            }
        }
        System.out.println(count);
    }
}
