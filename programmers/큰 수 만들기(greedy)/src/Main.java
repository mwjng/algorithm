import java.util.*;

class Solution {
    static int N;
    static int[] num;
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        N = number.length() - k;
        num = new int[number.length()];
        for(int i = 0; i < num.length; i++) {
            num[i] = number.charAt(i) -'0';
        }

        int idx = 0;
        int v = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {
            max = 0;
            for(int j = idx; j <= num.length-N+v; j++) {
                if(max < num[j]) {
                    max = num[j];
                    idx = j+1;
                }
            }
            v++;
            sb.append(max);
        }
        String answer = String.valueOf(sb);
        return answer;
    }
}