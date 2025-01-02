import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1]*(long)n;
        while(left <= right) {
            long mid = (left + right)/2;
            long tmp = 0;
            for(int i = 0; i < times.length; i++) {
                tmp += (mid/times[i]);
            }
            if(tmp >= n) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
}