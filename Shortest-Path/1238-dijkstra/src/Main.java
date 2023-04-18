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
    static int N, M, X;
    static List<Edge>[] list, rlist;
    static int[] dist, rdist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        list = new ArrayList[N];
        rlist = new ArrayList[N];
        dist = new int[N];
        rdist = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            rlist[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(rdist, Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end, weight));
            rlist[end].add(new Edge(start, weight));
        }

        dijkstra(X, dist, list);
        dijkstra(X, rdist, rlist);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            max = Math.max(max, dist[i] + rdist[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start, int[] d, List<Edge>[] list) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N];
        pq.offer(new Edge(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!visit[e.end]) {
                visit[e.end] = true;
                for(Edge temp : list[e.end]) {
                    if(d[temp.end] > d[e.end] + temp.weight) {
                        d[temp.end] = d[e.end] + temp.weight;
                        pq.offer(new Edge(temp.end, d[temp.end]));
                    }
                }
            }
        }
    }
}
