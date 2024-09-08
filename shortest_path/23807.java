import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end;
        long weight;
        public Edge(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static int N, M, X, Z, P;
    static List<Edge>[] list;
    static List<Integer> vtx;
    static long[][] dist;
    static boolean[] isSelected;
    static int[] numbers;
    static long min;
    static final long INF = (long) 1e12;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        vtx = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            list[a].add(new Edge(b, weight));
            list[b].add(new Edge(a, weight));
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(br.readLine());
        dist = new long[P][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            vtx.add(Integer.parseInt(st.nextToken()));
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < P; i++) {
            dijkstra(i);
        }
        min = INF;
        isSelected = new boolean[P];
        numbers = new int[3];
        permutation(0);
        if(min == INF) System.out.print(-1);
        else System.out.print(min);
    }

    static void calc() {
        long sum = dist[numbers[0]][X] + dist[numbers[1]][vtx.get(numbers[0])]
                + dist[numbers[2]][vtx.get(numbers[1])] + dist[numbers[2]][Z];
        min = Math.min(min, sum);
    }

    static void permutation(int depth) {
        if (depth == 3) {
            calc();
            return;
        }
        for (int i = 0; i < P; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            numbers[depth] = i;
            permutation(depth+1);
            isSelected[i] = false;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.offer(new Edge(vtx.get(start), 0));
        dist[start][vtx.get(start)] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if(dist[start][e.end] > cur.weight + e.weight) {
                        dist[start][e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist[start][e.end]));
                    }
                }
            }
        }
    }
}