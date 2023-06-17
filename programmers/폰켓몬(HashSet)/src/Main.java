import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        if(set.size() < N)
            answer = set.size();
        else
            answer = N;
        return answer;
    }
}