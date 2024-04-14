package Java.coding_test.programmers.대표유형.해시.의상;

import java.util.*;
import java.io.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static int[] kinds;
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        answer--;
        return answer;
    }
}