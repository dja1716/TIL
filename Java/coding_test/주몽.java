import java.io.*;
import java.util.StringTokenizer;

public class Main {
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
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(materials[i] + materials[j] == target) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
