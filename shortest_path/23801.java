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
    static long[] dist1, dist2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        vtx = new ArrayList<>();
        dist1 = new long[N+1];
        dist2 = new long[N+1];
        Arrays.fill(dist1, Long.MAX_VALUE);
        Arrays.fill(dist2, Long.MAX_VALUE);
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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            vtx.add(Integer.parseInt(st.nextToken()));
        }
        dijkstra(X, dist1);
        dijkstra(Z, dist2);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < vtx.size(); i++) {
            if(dist1[vtx.get(i)] == Long.MAX_VALUE || dist2[vtx.get(i)] == Long.MAX_VALUE) continue;
            min = Math.min(min, dist1[vtx.get(i)] + dist2[vtx.get(i)]);
        }
        if(min == Long.MAX_VALUE) System.out.print(-1);
        else System.out.print(min);
    }

    static void dijkstra(int start, long[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if(dist[e.end] > cur.weight + e.weight) {
                        dist[e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist[e.end]));
                    }
                }
            }
        }
    }
}