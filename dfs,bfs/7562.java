import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int x, y, fx, fy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visit = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());

            bfs(x, y);

        }

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tx = tmp[0];
            int ty = tmp[1];
            if(tx == fx && ty == fy) {
                System.out.println(map[tx][ty]);
                return;
            }
            for(int i = 0; i < 8; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(!visit[nx][ny]) {
                        q.offer(new int[] {nx, ny});
                        visit[nx][ny] = true;
                        map[nx][ny] = map[tx][ty] + 1;
                    }
                }
            }
        }
    }

}