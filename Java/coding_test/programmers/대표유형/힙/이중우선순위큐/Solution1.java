package Java.coding_test.programmers.대표유형.힙.이중우선순위큐;

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> deletedMax = new HashMap<>();
        Map<Integer, Integer> deletedMin = new HashMap<>();
        
        for(int i = 0; i < operations.length; i++) {
            String[] cmd = operations[i].split(" ");
            int second = Integer.parseInt(cmd[1]);
            if(cmd[0].equals("I")) {
                
                minHeap.add(second);
                maxHeap.add(second);
            } else {
                if(second == 1) {
                    while(!maxHeap.isEmpty()) {
                        int poll = maxHeap.poll();
                        
                        if(deletedMax.containsKey(poll)) {
                            if(deletedMax.get(poll) == 1) {
                                deletedMax.remove(poll);
                            } else {
                                deletedMax.put(poll, deletedMax.get(poll) - 1);
                            }
                            continue;
                        } else {
                            System.out.println(poll);
                            deletedMin.put(poll, deletedMin.getOrDefault(poll, 0) + 1);
                            break;
                        }
                    }
                } else {
                    while(!minHeap.isEmpty()) {
                        int poll = minHeap.poll();
                        if(deletedMin.containsKey(poll)) {
                            if(deletedMin.get(poll) == 1) {
                                deletedMin.remove(poll);
                            } else {
                                deletedMin.put(poll, deletedMin.get(poll) - 1);
                            }
                            continue;
                        } else {
                            deletedMax.put(poll, deletedMax.getOrDefault(poll, 0) + 1);
                            break;
                        }
                    }
                }
            }
        }
        
        while(!minHeap.isEmpty()) {
            int poll = minHeap.poll();
            if(deletedMin.getOrDefault(poll, 0) == 0) {
                answer[1] = poll;
                break;
            }
            deletedMin.put(poll, deletedMin.get(poll) - 1);
        }
        while(!maxHeap.isEmpty()) {
            int poll = maxHeap.poll();
            if(deletedMax.getOrDefault(poll, 0) == 0) {
                answer[0] = poll;
                break;
            }
            deletedMax.put(poll, deletedMax.get(poll) - 1);
        }
        return answer;
    }
}