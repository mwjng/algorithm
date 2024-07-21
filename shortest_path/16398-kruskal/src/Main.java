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
    static int N;
    static List<Edge> list = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                list.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        Collections.sort(list);

        int cnt = 0;
        int idx = 0;
        long res = 0;
        while(cnt < N-1) {
            Edge e = list.get(idx++);
            int x = find(e.start);
            int y = find(e.end);
            if(x != y) {
                parent[y] = x;
                res += e.weight;
                cnt++;
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