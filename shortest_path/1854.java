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

    static int n,m,k;
    static List<Edge>[] list;
    static PriorityQueue<Integer>[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dist = new PriorityQueue[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }
        dijkstra(1);
        int res;
        for(int i=1; i<=n; i++) {
            res = dist[i].size() != k ? -1 : dist[i].peek();
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start].offer(0);
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for(Edge e : list[cur.end]) {
                int weight = cur.weight + e.weight;
                if(dist[e.end].size() < k) {
                    pq.offer(new Edge(e.end, weight));
                    dist[e.end].offer(weight);
                }
                else if (dist[e.end].peek() > weight) {
                    pq.offer(new Edge(e.end, weight));
                    dist[e.end].poll();
                    dist[e.end].offer(weight);
                }
            }
        }
    }
}