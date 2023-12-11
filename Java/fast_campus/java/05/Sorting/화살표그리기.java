import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    static int N;
    static Elem[] arr;
    static class Elem implements Comparable<Elem> {
        public int color;
        public int place;
        
        
        @Override
        public int compareTo(Elem others) {
            if(color != others.color) {
                return color - others.color;
            }
            
            return place - others.place;
        } 
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        arr = new Elem[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Elem temp = new Elem();
            temp.place = Integer.parseInt(st.nextToken());
            temp.color = Integer.parseInt(st.nextToken());
            
            arr[i] = temp;
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            if(i < N - 1 && arr[i].color == arr[i+1].color) {
                left = arr[i+1].place - arr[i].place;
            }
            if(i > 0 && arr[i-1].color == arr[i].color) {
                right = arr[i].place - arr[i-1].place;
            }
            ans += Math.min(left, right);
        }
        System.out.println(ans);
    }
}
