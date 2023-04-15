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
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end=  Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Edge(start, end, weight));
        }

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        while(!pq.isEmpty()) {
            Edge temp = pq.poll();
            int x = find(temp.start);
            int y = find(temp.end);
            if(x != y) {
                parent[y] = x;
                sum += temp.weight;
                max = temp.weight;
            }
        }

        bw.write((sum - max) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int i) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }
}
