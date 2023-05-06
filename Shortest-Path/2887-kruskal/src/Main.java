import java.io.*;
import java.util.*;

class Point {
    int num, x, y, z;
    Point(int num, int x, int y, int z) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
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
    static Point[] points;
    static List<Edge> list;
    static int[] parent;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        points = new Point[N];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y, z);
        }

        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);

        for(int i = 0; i < N-1; i++) {
            list.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].x - points[i+1].x)));
        }

        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);

        for(int i = 0; i < N-1; i++) {
            list.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].y - points[i+1].y)));
        }

        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);

        for(int i = 0; i < N-1; i++) {
            list.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].z - points[i+1].z)));
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        int index = 0;
        while(cnt < N-1) {
            Edge e = list.get(index++);
            int x = find(e.start);
            int y = find(e.end);
            if(x != y) {
                parent[y] = x;
                sum += e.weight;
                cnt++;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int idx) {
        if(idx == parent[idx])
            return idx;
        else
            return parent[idx] = find(parent[idx]);
    }
}
