import java.io.*;
import java.util.*;

class Coo implements Comparable<Coo>{
    int x, y, cnt;
    Coo(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    public int compareTo(Coo c) {
        return this.cnt - c.cnt;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        PriorityQueue<Coo> pq = new PriorityQueue<>();
        pq.offer(new Coo(0, 0, 0));
        visit[0][0] = true;
        while(!pq.isEmpty()) {
            Coo c = pq.poll();
            if(c.x == N-1 && c.y == M-1) {
                res = c.cnt;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny]) {
                    if(map[nx][ny] == 1) {
                        pq.offer(new Coo(nx, ny, c.cnt+1));
                    }
                    else {
                        pq.offer(new Coo(nx, ny, c.cnt));
                    }
                    visit[nx][ny] = true;
                }
            }
        }
    }
}
