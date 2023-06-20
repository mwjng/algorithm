import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for(int i : lost) {
            lostList.add(i);
        }

        for(int i : reserve) {
            reserveList.add(i);
        }

        List<Integer> common = new ArrayList<>();

        for(int i : lostList) {
            if(reserveList.contains(i)) {
                common.add(i);
            }
        }

        lostList.removeAll(common);
        reserveList.removeAll(common);
        Collections.sort(reserveList);

        for(int i : reserveList) {
            if(lostList.contains(i-1)) {
                lostList.remove(Integer.valueOf(i-1));
            }
            else if(lostList.contains(i+1)) {
                lostList.remove(Integer.valueOf(i+1));
            }
        }

        int answer = n - lostList.size();
        return answer;
    }
}