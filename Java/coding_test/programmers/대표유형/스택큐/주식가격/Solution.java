package Java.coding_test.programmers.대표유형.스택큐.주식가격;

import java.util.*;
import java.io.*;

class Solution {
    static class Stock {
        int price;
        int idx;
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> s = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
            while(!s.isEmpty()) {
                Stock temp = s.peek();
                if(temp.price > prices[i]) {
                    answer[temp.idx] = i - temp.idx;
                    s.pop();
                } else {
                    break;
                }
            }
            Stock ns = new Stock();
            ns.price = prices[i];
            ns.idx = i;
            s.push(ns);
        }
        while(!s.isEmpty()) {
            Stock pop = s.pop();
            answer[pop.idx] = answer.length - pop.idx - 1;
        }
        return answer;
    }
}