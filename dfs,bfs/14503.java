import java.util.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(r, c);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            cnt++;
        }
        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int tx = x + dx[d];
            int ty = y + dy[d];
            if(tx >= 0 && tx < N && ty >= 0 && ty < M && !visited[tx][ty] && map[tx][ty] == 0) {
                dfs(tx, ty);
                return;
            }
        }
        int bx = x - dx[d];
        int by = y - dy[d];
        if(bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] == 0) {
            dfs(bx, by);
        }
    }
}