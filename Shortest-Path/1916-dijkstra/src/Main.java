import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int end, weight;
    Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
public class Main {
    static int N, M;
    static int start, end;
    static int INF = Integer.MAX_VALUE;
    static List<Edge>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);

        dijkstra(start);

        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        boolean[] check = new boolean[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge temp = pq.poll();
            int tmp = temp.end;
            if(!check[tmp]) {
                check[tmp] = true;
                for(Edge e : list[tmp]) {
                    if(dist[e.end] > temp.weight + e.weight) {
                        dist[e.end] = temp.weight + e.weight;
                        pq.offer(new Edge(e.end, dist[e.end]));
                    }
                }
            }
        }
    }
}
