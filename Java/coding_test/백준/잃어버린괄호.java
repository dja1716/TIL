package coding_test.백준;
import java.util.*;
import java.io.*;


public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        
        
        String[] subA = input.split("\\-");

        int total = helper(subA[0]);
        for(int i = 1; i < subA.length; i++) {
            total -= helper(subA[i]);
        }
        System.out.println(total);
    }
    
    public static int helper(String s) {
        String[] sub = s.split("\\+");
        int result = 0;
        
        for(int i = 0; i < sub.length; i++) {
            result += Integer.parseInt(sub[i]);
        }
        
        return result;
    }
}
