import java.util.*;

class Solution {
    public int solution(int[] cit) {
        int answer = 0;
        Arrays.sort(cit);
        for(int i = 0; i < cit.length; i++) {
            if(cit.length - i <= cit[i]) {
                answer = cit.length - i;
                break;
            }
        }

        return answer;
    }
}