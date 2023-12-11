import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // input line 1
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int sN = Integer.parseInt(st.nextToken());
        int pN = Integer.parseInt(st.nextToken());
        
        // input 2
        st = new StringTokenizer(bf.readLine());
        
        char[] dna = st.nextToken().toCharArray();
        
        // input 3
        st = new StringTokenizer(bf.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        
        // input end
        
        int start = 0;
        int count = 0;
        int end = pN - 1;
        DnaCode codes = new DnaCode(a, c, g, t);
        for(int i = 0; i < pN; i++) {
            char code = dna[i];
            
            codes.add(code);
        }
        if(codes.isCorrect()) {
            count++;
        }
        while(end < sN - 1) {
            char removedCode = dna[start++];
            char addedCode = dna[++end];
            codes.remove(removedCode);
            codes.add(addedCode);
            
            if(codes.isCorrect()) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}

class DnaCode {
    int a = 0;
    int c = 0;
    int g = 0;
    int t = 0;
    
    public boolean isCorrect() {
        
        return a <= 0 && c <= 0 && g <= 0 && t <= 0;
    }
    public DnaCode(int a, int c, int g, int t) {
        this.a = a;
        this.c = c;
        this.g = g;
        this.t = t;
    }
    
    public void remove(char c) {
        switch(c) {
            case 'A':
                this.a++;
                break;
            case 'C':
                this.c++;
                break;
            case 'G':
                this.g++;
                break;
            case 'T':
                this.t++;
                break;
        }
    }
    
    public void add(char c) {
        switch(c) {
            case 'A':
                this.a--;
                break;
            case 'C':
                this.c--;
                break;
            case 'G':
                this.g--;
                break;
            case 'T':
                this.t--;
                break;
        }
    }
}
