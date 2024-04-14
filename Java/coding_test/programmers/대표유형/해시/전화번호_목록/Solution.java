package Java.coding_test.programmers.대표유형.해시.전화번호_목록;

import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> s = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> {
            return a.length() - b.length();
        });
        A:
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j <= phone_book[i].length(); j++) {
                String temp = phone_book[i].substring(0, j);
                if(s.contains(temp)) {
                    answer = false;
                    break A;
                }
            }
            s.add(phone_book[i]);
        }
        return answer;
    }
}