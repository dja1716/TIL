package 나무자르기;

import java.util.*;
import java.io.*;

public class 나무자르기 {
    static int[] trees;
    static int N;
    static int M;
    static BufferedReader bf;
    static int treeMaxHeight = -1;
    
    
    public static void main(String[] args) throws IOException {
        getInput();
        process();
    }
    
    public static void getInput() throws IOException {
        bf = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        trees = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > treeMaxHeight) {
                treeMaxHeight = trees[i];
            }
        }
    }
    
    public static void process() {
        int left = 0;
        int right = treeMaxHeight;
        int result = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            long temp = getTreesCut(mid);
            
            if(temp >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
    
    
    public static long getTreesCut(int height) {
        long result = 0;
        for(int i = 0; i < N; i++) {
            if(trees[i] > height) {
                result += (long) (trees[i] - height);
            }
        }
        
        return result;
    }
}
