import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int t = 0; t < commands.length; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            List<Integer> list = new ArrayList<>();

            for(int u = i-1; u <= j-1; u++) {
                list.add(array[u]);
            }

            Collections.sort(list);

            answer[t] = list.get(k-1);
        }
        return answer;
    }
}