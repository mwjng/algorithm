import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int num, max, maxKey;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            max = -1;
            maxKey = -1;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1000; j++) {
                num = Integer.parseInt(st.nextToken());
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.replace(num, map.get(num)+1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    maxKey = entry.getKey();
                } else if (entry.getValue() == max && entry.getKey() > maxKey) {
                    maxKey = entry.getKey();
                }
            }

            bw.write("#" + i + " " + maxKey + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}