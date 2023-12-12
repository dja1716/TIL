package coding_test.백준;
import java.util.*;
import java.io.*;

public class 수정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        for(int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // swap
                    isSwapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!isSwapped) break;
        }
        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        bf.close();
    }
}
