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
    static int n, m, r;
    static int[] item;
    static List<Edge>[] list;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n+1];
        list = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
            list[end].add(new Edge(start, weight));
        }

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }

        bw.write(max +"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start) {
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        int sum = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!visit[e.end]) {
                visit[e.end] = true;
                for(Edge temp : list[e.end]) {
                    if(dist[temp.end] > dist[e.end] + temp.weight) {
                        dist[temp.end] = dist[e.end] + temp.weight;
                        pq.offer(new Edge(temp.end, dist[temp.end]));
                    }
                }
            }
        }

        for(int i = 1; i < dist.length; i++) {
            if(dist[i] <= m) {
                sum += item[i];
            }
        }

        return sum;
    }
}
