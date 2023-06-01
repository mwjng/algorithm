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
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            sb.append("Problem " + cnt + ": " + dist[N-1][N-1] + "\n");
            cnt++;
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][N];
        pq.offer(new Edge(0, 0, map[0][0]));
        dist[0][0] = map[0][0];
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(!visit[e.x][e.y]) {
                visit[e.x][e.y] = true;
                for(int i = 0; i < 4; i++) {
                    int nx = e.x + dx[i];
                    int ny = e.y + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
                        if(dist[nx][ny] > dist[e.x][e.y] + map[nx][ny]) {
                            dist[nx][ny] = dist[e.x][e.y] + map[nx][ny];
                            pq.offer(new Edge(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }
        }
    }
}