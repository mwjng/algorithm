import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int end, weight;
    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class Main {
    static int n, m;
    static List<Edge>[] list;
    static List<Integer>[] routes;
    static int[] dist;
    static boolean[] visit;
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        routes = new ArrayList[n+1];
        visit = new boolean[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            routes[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 출발지
        b = Integer.parseInt(st.nextToken()); // 도착지

        dijkstra();

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b] + "\n");
        sb.append(routes[b].size() + "\n");
        for(int i = 0; i < routes[b].size(); i++) {
            sb.append(routes[b].get(i) + " ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(a, 0));
        dist[a] = 0;
        routes[a].add(a);
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!visit[e.end]) {
                visit[e.end] = true;
                for(int i = 0; i < list[e.end].size(); i++) {
                    Edge temp = list[e.end].get(i);
                    if(dist[temp.end] > dist[e.end] + temp.weight) {
                        dist[temp.end] = dist[e.end] + temp.weight;
                        routes[temp.end].clear();
                        for(int j = 0; j < routes[e.end].size(); j++) {
                            routes[temp.end].add(routes[e.end].get(j));
                        }
                        routes[temp.end].add(temp.end);
                        pq.offer(new Edge(temp.end, dist[temp.end]));
                    }
                }
            }
        }
    }
}
