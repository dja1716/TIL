import java.io.*;
import java.util.*;

// 더 많이 준 사람이 다음달에 선물 한 개 받음
// 같으면 지수가 큰사람이 받음
// 둘다 같으면 안 받음

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] board = new int[friends.length][friends.length];
        int[] arr = new int[friends.length];
        int[] answers = new int[friends.length];
        Map<String, Integer> nameToIdx = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            nameToIdx.put(friends[i], i);
        }
        for(int i = 0; i < gifts.length; i++) {
            String[] parts = gifts[i].split(" ");
            board[nameToIdx.get(parts[0])][nameToIdx.get(parts[1])]++;
            arr[nameToIdx.get(parts[0])]++;
            arr[nameToIdx.get(parts[1])]--;
        }
        for(int i = 0; i < friends.length; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                int temp1 = board[i][j];
                int temp2 = board[j][i];
                if(temp1 > temp2) {
                    answers[i]++;
                    continue;
                }
                if(temp1 < temp2) {
                    answers[j]++;
                    continue;
                }
                if(arr[i] > arr[j]) {
                    answers[i]++;
                } 
                if(arr[i] < arr[j]) {
                    answers[j]++;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, answers[i]);
        }
        return answer;
    }
}