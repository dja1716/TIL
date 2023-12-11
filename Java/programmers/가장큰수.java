import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numStrs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        if (numStrs[0].equals("0")) {
            return "0"; // Handle the case when all numbers are 0
        }

        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }

        return sb.toString();
    }
}
