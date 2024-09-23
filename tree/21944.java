import java.util.*;
import java.io.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int num, level, kind;
        public Problem(int num, int level, int kind) {
            this.num = num;
            this.level = level;
            this.kind = kind;
        }

        @Override
        public int compareTo(Problem o) {
            if(level == o.level) return Integer.compare(this.num, o.num);
            return Integer.compare(this.level, o.level);
        }
    }

    static Map<Integer, Problem> map = new HashMap<>();
    static Map<Integer, TreeSet<Problem>> kinds = new HashMap<>();
    static TreeSet<Problem> problems = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            Problem tmp = new Problem(P, L, G);
            map.put(P, tmp);
            kinds.putIfAbsent(G, new TreeSet<>());
            kinds.get(G).add(tmp);
            problems.add(tmp);
        }
        int M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                recommend(g, x);
            } else if (cmd.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                recommend2(x);

            } else if (cmd.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                recommend3(x, l);
            } else if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                add(P, L, G);
            } else {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }
        System.out.print(sb);
    }

    private static void solved(int p) {
        Problem tmp = map.get(p);
        problems.remove(tmp);
        kinds.get(tmp.kind).remove(tmp);
        map.remove(p);
    }

    private static void add(int p, int l, int g) {
        Problem tmp = new Problem(p, l, g);
        map.put(p, tmp);
        kinds.putIfAbsent(g, new TreeSet<>());
        kinds.get(g).add(tmp);
        problems.add(tmp);
    }

    private static void recommend3(int x, int l) {
        if (x == 1) {
            Problem tmp = problems.ceiling(new Problem(0, l, 0));
            int res = tmp == null ? -1 : tmp.num;
            sb.append(res + "\n");
        }
        else {
            Problem tmp = problems.lower(new Problem(0, l, 0));
            int res = tmp == null ? -1 : tmp.num;
            sb.append(res + "\n");
        }
    }

    private static void recommend2(int x) {
        if (x == 1) sb.append(problems.last().num + "\n");
        else sb.append(problems.first().num + "\n");
    }

    private static void recommend(int g, int x) {
        if (x == 1) sb.append(kinds.get(g).last().num + "\n");
        else sb.append(kinds.get(g).first().num + "\n");
    }
}