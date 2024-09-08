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

    static int N, M, S, D;
    static List<Edge>[] list;
    static List<Integer>[] reverseList;
    static boolean[][] isShortestPath;
    static int[] dist1, dist2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            list = new ArrayList[N];
            reverseList = new ArrayList[N];
            isShortestPath = new boolean[N][N];
            dist1 = new int[N];
            dist2 = new int[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                reverseList[i] = new ArrayList<>();
            }
            Arrays.fill(dist1, Integer.MAX_VALUE);
            Arrays.fill(dist2, Integer.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[from].add(new Edge(to, weight));
                reverseList[to].add(from);
            }
            dijkstra1(S);
            if (dist1[D] == Integer.MAX_VALUE) {
                sb.append(-1 + "\n");
                continue;
            }
            shortestPath(D);
            int result = dijkstra2(S);
            sb.append((result == Integer.MAX_VALUE ? -1 : result) + "\n");
        }
        System.out.print(sb);
    }

    static void dijkstra1(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.offer(new Edge(start, 0));
        dist1[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if (dist1[e.end] > cur.weight + e.weight) {
                        dist1[e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist1[e.end]));
                    }
                }
            }
        }
    }

    static void shortestPath(int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(end);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int bef : reverseList[cur]) {
                int weight = list[bef].stream().filter(e -> e.end == cur).findFirst().get().weight;
                if (dist1[cur] == dist1[bef] + weight) {
                    if (!isShortestPath[bef][cur]) {
                        isShortestPath[bef][cur] = true;
                        q.offer(bef);
                    }
                }
            }
        }
    }

    static int dijkstra2(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        pq.offer(new Edge(start, 0));
        dist2[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(!visited[cur.end]) {
                visited[cur.end] = true;
                for (Edge e : list[cur.end]) {
                    if (isShortestPath[cur.end][e.end]) continue;
                    if (dist2[e.end] > cur.weight + e.weight) {
                        dist2[e.end] = cur.weight + e.weight;
                        pq.offer(new Edge(e.end, dist2[e.end]));
                    }
                }
            }
        }
        return dist2[D];
    }
}