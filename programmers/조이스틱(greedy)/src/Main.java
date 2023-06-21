import java.util.*;

class Solution {
    public int solution(String name) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A') {
                list.add(i);
            }
        }

        int min = 0;

        if(list.size() == 1) {
            min = Math.min(list.get(0), name.length() - list.get(0));
        }
        else if(list.size() > 1) {
            if(list.get(0) == 0) {
                min = Math.min(list.get(list.size()-1), name.length() - list.get(1));
            }
            else {
                min = Math.min(list.get(list.size()-1), name.length() - list.get(0));
            }
            for(int i = 0; i < list.size()-1; i++) {
                int dist1 = list.get(i)*2 + name.length() - list.get(i+1);
                int dist2 = (name.length() - list.get(i+1))*2 + list.get(i);
                min = Math.min(min, (Math.min(dist1, dist2)));
            }
        }

        for(int i = 0; i < list.size(); i++) {
            char c = name.charAt(list.get(i));
            min += Math.min(c-'A', 'Z'-c+1);
        }

        int answer = min;
        return answer;
    }
}