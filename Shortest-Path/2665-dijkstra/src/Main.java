import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int x, y, weight;
    Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0' == 0 ? 1 : 0;
            }
        }

        dijkstra();

        bw.write(String.valueOf(dist[n-1][n-1]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0, 0));
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!visit[e.x][e.y]) {
                visit[e.x][e.y] = true;
                for(int i = 0; i < 4; i++) {
                    int nx = e.x + dx[i];
                    int ny = e.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if(dist[nx][ny] > map[nx][ny] + e.weight) {
                            dist[nx][ny] = map[nx][ny] + e.weight;
                            pq.offer(new Edge(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }
        }
    }
}
