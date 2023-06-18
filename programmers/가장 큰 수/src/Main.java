import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] res = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            res[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(res, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b));
        if(res[0].equals("0"))
            return "0";
        String answer = String.join("", res);
        return answer;
    }
}