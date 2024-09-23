import java.util.*;
import java.io.*;

public class Main {
    static class Building {
        int L, H, R;
        public Building(int l, int h, int r) {
            L = l;
            H = h;
            R = r;
        }
    }

    static int N;
    static TreeMap<Integer, List<Building>> map = new TreeMap<>();
    static TreeSet<Building> set = new TreeSet<>(
            Comparator.comparingInt((Building b) -> b.H)
                    .thenComparingInt(b -> b.R));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            map.putIfAbsent(L, new ArrayList<>());
            map.putIfAbsent(R, new ArrayList<>());
            Building b = new Building(L, H, R);
            map.get(L).add(b);
            map.get(R).add(b);
        }

        int height = 0;
        for (Map.Entry<Integer, List<Building>> entry : map.entrySet()) {
            int key = entry.getKey();
            for (Building b : entry.getValue()) {
                if(b.L == key) set.add(b);
                else if(b.R == key) set.remove(b);
            }
            if(set.isEmpty()) {
                height = 0;
                sb.append(key + " " + height + " ");
            }
            else if(set.last().H != height) {
                height = set.last().H;
                sb.append(key + " " + height + " ");
            }
        }
        System.out.print(sb);
    }
}