package Java.coding_test.programmers.대표유형.투포인터.연속된부분수열의합;

import java.util.*;

class Solution {
    public int[] solution(int[] seq, int k) {
        int[] answer = new int[2];
        int foundStart = -1;
        int foundEnd = -1;
        int sum = seq[0];
        int end = 0;
        for(int start = 0; start < seq.length; start++) {
            if(sum == k) {
                if(foundStart == -1 || end - start < foundEnd - foundStart) {
                    foundEnd = end;
                    foundStart = start;
                }
            } else if(sum < k) {
                while(end < seq.length - 1) {
                    if(sum >= k) {
                        break;
                    }
                    end++;
                    sum += seq[end];
                }
                if(sum == k) {
                    if(foundStart == -1 || end - start < foundEnd - foundStart) {
                        foundEnd = end;
                        foundStart = start;
                    }
                }
            }
            sum -= seq[start];
        }
        return new int[]{foundStart, foundEnd};
    }
}