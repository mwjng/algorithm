import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int start, end, weight;
    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
public class Main {
    static int N, M;
    static List<Edge> list = new ArrayList<>();
    static List<Edge> res = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(start, end, weight));
        }

        Collections.sort(list, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int count = 0;
        int idx = 0;

        while(count < N-1) {
            Edge e = list.get(idx++);
            int x = find(e.start);
            int y = find(e.end);

            if(x != y) {
                res.add(e);
                parent[y] = x;
                count++;
            }
        }

        int sum = 0;
        for(int i = 0; i < res.size(); i++) {
            sum += res.get(i).weight;
        }

        System.out.println(sum);
    }

    public static int find(int idx) {
        if(parent[idx] == idx) {
            return idx;
        }
        return find(parent[idx]);
    }
}
