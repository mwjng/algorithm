import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, map);

        System.out.println(max);
    }

    public static int maxValue(int[][] map) {
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }

    public static void find(int depth, int[][] map) {
        if(depth == 5) {
            int tmp = maxValue(map);
            max = Math.max(max, tmp);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int[][] copy = new int[N][N];
            for(int k = 0; k < N; k++) {
                copy[k] = map[k].clone();
            }
            boolean[][] check = new boolean[N][N];
            move(i, copy, check);
            find(depth+1, copy);
        }
    }

    public static void move(int d, int[][] map, boolean[][] check) {
        switch (d) {
            case 0:
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        dfs(i, j, 0, map, check);
                    }
                }
                break;
            case 1:
                for(int i = N-1; i >= 0; i--) {
                    for(int j = 0; j < N; j++) {
                        dfs(i, j, 1, map, check);
                    }
                }
                break;
            case 2:
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        dfs(j, i, 2, map, check);
                    }
                }
                break;
            case 3:
                for(int i = N-1; i >= 0; i--) {
                    for(int j = 0; j < N; j++) {
                        dfs(j, i, 3, map, check);
                    }
                }
                break;
        }
    }

    public static void dfs(int x, int y, int d, int[][] map, boolean[][] check) {
        int tx = x + dx[d];
        int ty = y + dy[d];
        if(tx >= 0 && ty >= 0 && tx < N && ty < N) {
            if(map[tx][ty] == 0) {
                map[tx][ty] = map[x][y];
                map[x][y] = 0;
                dfs(tx, ty, d, map, check);
            }
            else if(map[tx][ty] == map[x][y] && !check[tx][ty]) {
                map[tx][ty] *= 2;
                check[tx][ty] = true;
                map[x][y] = 0;
            }
        }
    }
}
