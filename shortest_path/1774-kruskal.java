import java.util.*;
import java.io.*;

public class Main {
    static class Coo {
        int x, y;
        Coo(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;
        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static int N, M;
    static List<Coo> list = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Coo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                pq.offer(new Edge(i, j, getDistance(i, j)));
            }
        }
        double res = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.start, e.end)) {
                res += e.weight;
            }
        }
        bw.write(String.format("%.2f", res));
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if(ra == rb) return false;
        if(ra < rb) parents[rb] = ra;
        else parents[ra] = rb;
        return true;
    }

    static double getDistance(int i, int j) {
        return Math.sqrt(Math.pow(list.get(i).x - list.get(j).x, 2) + Math.pow(list.get(i).y - list.get(j).y, 2));
    }
}