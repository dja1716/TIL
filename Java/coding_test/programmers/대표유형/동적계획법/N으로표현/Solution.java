package Java.coding_test.programmers.대표유형.동적계획법.N으로표현;

import java.util.*;

class Solution {
    Set<Long>[] dp = new HashSet[9];
    public int solution(int N, int number) {
        long Ns = 0;
        for(int i = 1; i < dp.length; i++) {
            Ns = Ns * 10 + N;
            if(Ns == number) {
                return i; 
            }
            dp[i] = new HashSet<>();
            dp[i].add(Ns);
        }
        
        for(int i = 2; i <= 8; i++) {
            for(int j = 1; j < i ; j++) {
                for(long n1 : dp[j]) {
                    for(long n2: dp[i - j]) {
                        List<Long> toAdd = new ArrayList<>();
                        toAdd.add(n1 + n2);
                        toAdd.add(n1 - n2);
                        toAdd.add(n2 - n1);
                        toAdd.add(n1 * n2);
                        
                        if(n2 != 0) {
                            toAdd.add(n1 / n2);
                        }
                        if(n1 != 0) {
                            toAdd.add(n2 / n1);
                        }
                        for(long newN : toAdd) {
                            if(newN == number) {
                                return i;
                            }
                            dp[i].add(newN);
                        }
                    }
                }
            }
        }
        return -1;
    }
}