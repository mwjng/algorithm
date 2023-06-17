import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : participant) {
            // if(map.containsKey(str)) {
            //     map.put(str, map.get(str) + 1);
            // }
            // else {
            //     map.put(str, 1);
            // }

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for(String str : map.keySet()) {
            if(map.get(str) != 0) {
                answer = str;
            }
        }
        return answer;
    }
}