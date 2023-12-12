package coding_test;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// or import java.io.*;

public class 숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long answer = 0;
        String numbers = br.readLine();
        
        for(int i = 0; i < n; i++) {
            answer += numbers.charAt(i) - '0';
        }
        System.out.println(answer);
    }
}
