import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ex = {{-1, -1, -1}, {0, -1, 1}, {0, -1, 1}, {1, 1, 1}};
    static int[][] ey = {{0, -1, 1}, {1, 1, 1}, {-1, -1, -1}, {0, -1 ,1}};
    static int max = Integer.MIN_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sum = map[i][j];
                visited[i][j] = true;
                dfs(i, j, 0);
                visited[i][j] = false;

                check(i, j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        if(cnt == 3) {
            max = Math.max(sum, max);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                if(!visited[tx][ty]) {
                    visited[tx][ty] = true;
                    sum += map[tx][ty];
                    dfs(tx, ty, cnt+1);
                    visited[tx][ty] = false;
                    sum -= map[tx][ty];
                }
            }
        }
    }

    public static void check(int x, int y) {
        for(int i = 0; i < 4; i++) {
            boolean ck = false;
            int lsum = map[x][y];
            for(int j = 0; j < 3; j++) {
                int tx = x + ex[i][j];
                int ty = y + ey[i][j];
                if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                    lsum += map[tx][ty];
                }
                else {
                    ck = true;
                    break;
                }
            }
            if(!ck) {
                max = Math.max(lsum, max);
            }
        }
    }
}