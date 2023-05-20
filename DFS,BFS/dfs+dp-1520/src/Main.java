import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        d = new int[M][N];

        for(int i = 0; i < M; i++) {
            Arrays.fill(d[i], -1);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(dfs(0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x, int y) {
        if(x == M-1 && y == N-1)
            return 1;
        if(d[x][y] != -1)
            return d[x][y];

        d[x][y] = 0;

        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && ty >= 0 && tx < M && ty < N) {
                if(map[tx][ty] < map[x][y]) {
                    d[x][y] += dfs(tx, ty);
                }
            }
        }

        return d[x][y];
    }
}
