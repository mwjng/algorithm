import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int start, end, weight;
    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class Main {
    static int N, M, K;
    static List<Integer> f = new ArrayList<>();
    static List<Edge>[] list;
    static int[] parent;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        list = new ArrayList[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            f.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(start, end, weight));
            list[end].add(new Edge(end, start, weight));
        }

        for(int i = 0; i < f.size(); i++) {
            for(int j = 0; j < list[f.get(i)].size(); j++) {
                pq.offer(list[f.get(i)].get(j));
            }
        }

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int a = find(e.start);
            int b = find(e.end);
            if(!f.contains(b)) {
                parent[b] = a;
                res += e.weight;
                for(Edge tmp : list[e.end]) {
                    pq.offer(tmp);
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int i) {
        if(i == parent[i])
            return i;
        return parent[i] = find(parent[i]);
    }
}
