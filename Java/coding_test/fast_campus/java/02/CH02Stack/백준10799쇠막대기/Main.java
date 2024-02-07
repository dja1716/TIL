import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().replace("()", "*").toCharArray();
        int answer = 0;
        int height = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '*') {
                answer += height;
            }
            if(input[i] == '(') {
                height++;
            }
            if(input[i] == ')') {
                height--;
                answer++;
            }
        }
        bw.write(answer + "");
        bw.flush();
    }

}