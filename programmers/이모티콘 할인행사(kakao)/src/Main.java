import java.util.*;

class Solution {
    static int join = Integer.MIN_VALUE;
    static int pay = Integer.MIN_VALUE;
    static int[] discount = {10, 20, 30, 40};
    static List<Integer> list = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons) {

        dfs(0, emoticons, users);

        int[] answer = new int[2];
        answer[0] = join;
        answer[1] = pay;

        return answer;
    }

    public static void dfs(int depth, int[] emoticons, int[][] users) {
        if(depth == emoticons.length) {
            calc(emoticons, users);
            return;
        }
        for(int i = 0; i < 4; i++) {
            list.add(discount[i]);
            dfs(depth+1, emoticons, users);
            list.remove(depth);
        }
    }

    public static void calc(int[] emoticons, int[][] users) {
        int cnt = 0;
        int total = 0;
        for(int i = 0; i < users.length; i++) {
            int sum = 0;
            for(int j = 0; j < list.size(); j++) {
                if(users[i][0] <= list.get(j)) {
                    sum += emoticons[j] / 100 * (100 - list.get(j));
                }
            }
            if(sum >= users[i][1]) {
                cnt++;
            }
            else {
                total += sum;
            }
        }
        if(cnt > join) {
            join = cnt;
            pay = total;
        }
        else if(cnt == join) {
            pay = Math.max(pay, total);
        }
    }
}