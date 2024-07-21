import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int start, end, weight;
    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public int compareTo(Edge e1) {
        return this.weight - e1.weight;
    }
}
public class Main {
    static int V, E;
    static List<Edge> list = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(start, end, weight));
        }

        parent = new int[V+1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int idx = 0;
        int sum = 0;

        Collections.sort(list);

        while(cnt < V-1) {
            Edge e = list.get(idx++);
            int x = find(e.start);
            int y = find(e.end);
            if(x != y) {
                sum += e.weight;
                cnt++;
                parent[y] = x;
            }
        }

        System.out.println(sum);
    }

    public static int find(int i) {
        if(parent[i] == i)
            return i;
        return find(parent[i]);
    }
}
