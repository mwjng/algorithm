import java.util.*;
import java.io.*;

public class Main {
    static class Problem {
        int num, level;
        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    static Map<Integer, Problem> map = new HashMap<>();
    static TreeSet<Problem> problems = new TreeSet<>(
            Comparator.comparingInt((Problem p) -> p.level)
                    .thenComparingInt(p -> p.num));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Problem tmp = new Problem(P, L);
            map.put(P, tmp);
            problems.add(tmp);
        }
        int M = Integer.parseInt(br.readLine());
        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                recommend(x);
            } else if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                add(P, L);
            } else {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }
        System.out.print(sb);
    }

    private static void solved(int p) {
        problems.remove(map.get(p));
    }

    private static void add(int p, int l) {
        Problem tmp = new Problem(p, l);
        map.put(p, tmp);
        problems.add(tmp);
    }

    private static void recommend(int x) {
        if (x == 1) sb.append(problems.last().num + "\n");
        else sb.append(problems.first().num + "\n");
    }
}