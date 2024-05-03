package Java.coding_test.programmers.대표유형.수학.두원사이의정수쌍;

import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long outer = (long) r2 * (long) r2;
        long inner = (long) r1 * (long) r1;
        long answer = 0;
        for(long a = 1; a <= r2; a++) {
            long o = (long) Math.floor(Math.sqrt(outer - a * a));
            long i = (long) Math.ceil(Math.sqrt(inner - a * a));
            // System.out.println("a: " + a + " o: " + o + " i: " + i);
            answer += o - i + 1;
        }
        
        return answer * 4;
    }
}