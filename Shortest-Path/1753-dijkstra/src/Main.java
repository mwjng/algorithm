import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int end, weight;
    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;  // 우선순위 큐 정렬, 최솟값이 먼저 나옴
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int v, e, k;
    static List<Edge>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v+1];
        dist = new int[v+1];

        Arrays.fill(dist, INF);

        for(int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(k);
        for(int i = 1; i <= v; i++) {
            if(dist[i] == INF) {
                sb.append("INF\n");
            }
            else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(start, 0));
        boolean[] check = new boolean[v+1];
        dist[start] = 0;

        while(!q.isEmpty()) {
            Edge temp = q.poll();
            int tmp = temp.end;
            if(!check[tmp]) {
                check[tmp] = true;
                for(Edge e : list[tmp]) {
                    if(dist[e.end] > dist[tmp] + e.weight) {
                        dist[e.end] = dist[tmp] + e.weight;
                        q.add(new Edge(e.end, dist[e.end]));
                    }
                }
            }
        }
    }
}
