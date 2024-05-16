import java.io.*;
import java.util.*;

class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];
            dfs(0, 0, 1, 0);

            bw.write("#" + t + "\n");
            for (int i = 0; i < N; i++) {
                for (int j =0; j < N; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int cnt, int dir) {
        visited[x][y] = true;
        arr[x][y] = cnt;
        while (cnt < N*N) {
            int tx = x + dx[dir % 4];
            int ty = y + dy[dir % 4];
            if (tx >= 0 && tx < N && ty >= 0 && ty < N && !visited[tx][ty]) {
                dfs(tx, ty, cnt + 1, dir);
                break;
            }
            dir++;
        }
    }
}