import java.io.*;
import java.util.*;

class Solution {
    static int N, cnt;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }

            cnt = 0;
            calc();

            bw.write("#" + t + " " + cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void calc() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.' && !visited[i][j] && verify(i, j)) {
                    visited[i][j] = true;
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == '.' && !visited[i][j]) {
                    cnt++;
                }
            }
        }
    }

    static boolean verify(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                if (arr[tx][ty] == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx >= 0 && tx < N && ty >= 0 && ty < N && !visited[tx][ty]) {
                visited[tx][ty] = true;
                if (verify(tx, ty)) {
                    dfs(tx, ty);
                }
            }
        }
    }
}