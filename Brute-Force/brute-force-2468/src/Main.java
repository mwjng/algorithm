import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i <= 100; i++) {
            boolean[][] visit = new boolean[N][N];
            count = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(arr[j][k] > i && !visit[j][k]) {
                        dfs(i, visit, j, k);
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }

    public static void dfs(int n, boolean[][] visit, int x, int y) {
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && ty >= 0 && tx < N && ty < N) {
                if(!visit[tx][ty] && arr[tx][ty] > n) {
                    dfs(n, visit, tx, ty);
                }
            }
        }
    }
}