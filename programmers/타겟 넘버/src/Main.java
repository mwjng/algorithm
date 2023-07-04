import java.util.*;

class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0, 0);
        int answer = cnt;
        return answer;
    }

    public static void dfs(int[] numbers, int target, int idx, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        for(int i = idx; i < numbers.length; i++) {
            dfs(numbers, target, i+1, depth+1, sum+numbers[i]);
            dfs(numbers, target, i+1, depth+1, sum-numbers[i]);
        }
    }
}