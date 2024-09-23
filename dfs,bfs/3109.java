import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static char[][] arr;
    static boolean[][] visited;
    static boolean check;
    static int R, C, cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            check = false;
            dfs(i, 0);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        if (y == C - 1) {
            cnt++;
            check = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (arr[nx][ny] == '.' && !visited[nx][ny]) {
                    dfs(nx, ny);
                    if(check) return;
                }
            }
        }
    }
}