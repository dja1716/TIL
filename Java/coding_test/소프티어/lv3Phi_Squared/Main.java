package Java.coding_test.소프티어.lv3Phi_Squared;

import java.io.*;
import java.util.*;

public class Main {

    static Deque<Long> num = new LinkedList<>();
    static Deque<Long> nextNum = new LinkedList<>();
    static Deque<Integer> index = new LinkedList<>();
    static Deque<Integer> nextIndex = new LinkedList<>();
    static int N;
    
    
    public static void main(String[] args) throws IOException {
        
        pre();
        solve();
    }

    static void solve() {
        while(num.size() > 1) {
            while(!num.isEmpty()) {
                long cn = num.pollFirst();
                int ci = index.pollFirst();
                long result = cn;

                if(!num.isEmpty()) {
                    long nextN = num.peekFirst();
                    if(cn >= nextN) {
                        result += nextN;
                        num.pollFirst();
                        index.pollFirst();
                    }
                    
                }
                if(!nextNum.isEmpty()) {
                    long preN = nextNum.peekLast();
                    if(cn >= preN) {
                        result += preN;
                        nextNum.pollLast();
                        nextIndex.pollLast();
                    }
                }
                nextNum.addLast(result);
                nextIndex.addLast(ci);
            }
            num = nextNum;
            index = nextIndex;
            nextNum = new LinkedList<>();
            nextIndex = new LinkedList<>();
        }
        System.out.println(num.pollFirst());
        System.out.println(index.pollFirst());
    }

    static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            long input = Long.parseLong(st.nextToken());
            num.addLast(input);
            index.addLast(i);
        }
    }
}
