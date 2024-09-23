import java.io.*;
import java.util.*;

class Record implements Comparable<Record>{
    int x, y, time;

    Record(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int compareTo(Record o) {
        return this.time - o.time;
    }
}
class Solution {
    static int N, sx, sy, ex, ey;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;
            bfs();

            bw.write("#" + t + " " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        PriorityQueue<Record> q = new PriorityQueue<>();
        q.offer(new Record(sx, sy, 0));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Record r = q.poll();
            if (r.x == ex && r.y == ey) {
                min = Math.min(min, r.time);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tx = r.x + dx[i];
                int ty = r.y + dy[i];
                int tt = r.time;
                if (tx >= 0 && tx < N && ty >= 0 && ty < N && arr[tx][ty] != 1 && !visited[tx][ty]) {
                    if (arr[tx][ty] == 2) {
                        while (true) {
                            if (wind(tt)) {
                                break;
                            }
                            tt++;
                        }
                    }
                    q.offer(new Record(tx, ty, tt + 1));
                    visited[tx][ty] = true;
                }
            }
        }
        min = -1;
    }

    static boolean wind(int s) {
        return s % 3 == 2;
    }
}