import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// or import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        
        long answer = 0;
        
        for(int i = 0; i < n; i++) {
            answer += Long.parseLong(br.readLine());
        }
        
        System.out.println(answer);
    }
}
