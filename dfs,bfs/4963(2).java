import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                break;

            map = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    bfs(i, j);
                }
            }

            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y) {
        if(map[x][y] == 0 || visit[x][y]) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tx = temp[0];
            int ty = temp[1];

            for(int i = 0; i < 8; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        cnt++;
    }
}