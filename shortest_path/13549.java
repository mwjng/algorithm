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

    static int N, K;
    static int[] dist;
    static int len = (int) 1e5 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(N);
        System.out.print(dist[K]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[len];
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        int tmp;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                tmp = cur.end - 1;
                if(tmp >= 0 && tmp < len && dist[tmp] > cur.weight + 1) {
                    dist[tmp] = cur.weight + 1;
                    pq.offer(new Edge(tmp, cur.weight + 1));
                }
                tmp = cur.end + 1;
                if(tmp >= 0 && tmp < len && dist[tmp] > cur.weight + 1) {
                    dist[tmp] = cur.weight + 1;
                    pq.offer(new Edge(tmp, cur.weight + 1));
                }
                tmp = 2 * cur.end;
                if(tmp >= 0 && tmp < len && dist[tmp] > cur.weight) {
                    dist[tmp] = cur.weight;
                    pq.offer(new Edge(tmp, cur.weight));
                }
            }
        }
    }
}