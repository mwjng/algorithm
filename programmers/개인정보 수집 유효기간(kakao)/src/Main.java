import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] days = today.split("\\.");
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);
        int num = year*12*28 + month*28 + day;

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            StringTokenizer st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++) {
            privacies[i] = privacies[i].replace(".", " ");
            StringTokenizer st = new StringTokenizer(privacies[i]);
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            String kind = st.nextToken();

            m += map.get(kind);
            d--;
            if(d == 0) {
                m--;
                d = 28;
            }

            if(m > 12) {
                y += m / 12;
                m %= 12;
            }

            int tnum = y*12*28 + m*28 + d;
            if(tnum < num) {
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}