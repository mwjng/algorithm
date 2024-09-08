import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int end, weight;
        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M, X, Y, Z;
    static List<Edge>[] list, rlist;
    static int[] dist1, dist2, dist3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        rlist = new ArrayList[N+1];
        dist1 = new int[N+1];
        dist2 = new int[N+1];
        dist3 = new int[N+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Arrays.fill(dist3, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            rlist[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, weight));
            rlist[to].add(new Edge(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        dijkstra1(X);
        dijkstra2(Y, rlist, dist2);
        dijkstra2(Y, list, dist3);
        int result1 = dist1[Z] == Integer.MAX_VALUE ? -1 : dist1[Z];
        int result2 = dist2[X] == Integer.MAX_VALUE || dist3[Z] == Integer.MAX_VALUE ? -1 : dist2[X] + dist3[Z];
        bw.write(result2 + " " + result1);
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra1(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Edge(start, 0));
        dist1[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if(e.end == Y) continue;
                    if (dist1[e.end] > cur.weight + e.weight) {
                        dist1[e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist1[e.end]));
                    }
                }
            }
        }
    }

    static void dijkstra2(int start, List<Edge>[] list, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if (dist[e.end] > cur.weight + e.weight) {
                        dist[e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist[e.end]));
                    }
                }
            }
        }
    }
}