import java.util.*;

class Music {
    String genre;
    int idx, play;
    Music(String genre, int idx, int play) {
        this.genre = genre;
        this.idx = idx;
        this.play = play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> genArr = new ArrayList<>();

        while(!map.isEmpty()) {
            int max = Integer.MIN_VALUE;
            String genre = "";

            for(String key : map.keySet()) {
                if(max < map.get(key)) {
                    max = map.get(key);
                    genre = key;
                }
            }

            genArr.add(genre);
            map.remove(genre);
        }

        List<Integer> res = new ArrayList<>();

        for(String s : genArr) {
            List<Music> arr = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(s.equals(genres[i])) {
                    arr.add(new Music(genres[i], i, plays[i]));
                }
            }

            Collections.sort(arr, new Comparator<Music>() {
                public int compare(Music m1, Music m2) {
                    if(m1.play == m2.play)
                        return m1.idx - m2.idx;
                    else
                        return m2.play - m1.play;
                }
            });

            for(int i = 0; i < 2; i++) {
                if(i < arr.size()) {
                    res.add(arr.get(i).idx);
                }
            }

        }

        int[] answer = new int[res.size()];

        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}