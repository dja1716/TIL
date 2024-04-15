package Java.coding_test.programmers.대표유형.힙.이중우선순위큐;

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        
        for(int i = 0; i < operations.length; i++) {
            String[] cmd = operations[i].split(" ");
            int second = Integer.parseInt(cmd[1]);
            if(cmd[0].equals("I")) {
                
                minHeap.add(second);
                maxHeap.add(second);
            } else {
                if(second == 1) {
                    if(maxHeap.size() == 0) continue;
                    int poll = maxHeap.poll();
                    minHeap.remove(poll);
                } else {
                    if(minHeap.size() == 0) continue;
                    int poll = minHeap.poll();
                    minHeap.remove(poll);
                }
            }
        }
        if(minHeap.size() > 0) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}