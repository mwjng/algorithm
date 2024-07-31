import java.io.*;
import java.util.*;

class Core {
    int x, y;

    Core(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
class Solution {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int min;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Core> cores ;
    static int maxLink;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            cores = new ArrayList<>();
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            cores.add(new Core(i, j));
                        }
                    }
                }
            }

            maxLink = 0;
            dfs(0, 0, 0);
            bw.write("#" + t + " " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int len, int link) {
        if (depth == cores.size()) {
            if (link > maxLink) {
                maxLink = link;
                min = len;
            } else if (link == maxLink) {
                min = Math.min(min, len);
            }
            return;
        }
        for (int j = 0; j < 4; j++) {
            int x = cores.get(depth).x + dx[j];
            int y = cores.get(depth).y + dy[j];
            int length = 0;
            boolean check = true;
            while (x >= 0 && y >= 0 && x < N && y < N) {
                if (arr[x][y] == 1 || visit[x][y]) {
                    check = false;
                    x -= dx[j];
                    y -= dy[j];
                    while (x != cores.get(depth).x || y != cores.get(depth).y) {
                        visit[x][y] = false;
                        x -= dx[j];
                        y -= dy[j];
                    }
                    break;
                }
                length++;
                visit[x][y] = true;
                x += dx[j];
                y += dy[j];
            }
            if (check) {
                dfs(depth + 1, len + length, link+1);
                x -= dx[j];
                y -= dy[j];
                while (x != cores.get(depth).x || y != cores.get(depth).y) {
                    visit[x][y] = false;
                    x -= dx[j];
                    y -= dy[j];
                }
            }
        }
        dfs(depth + 1, len, link);
    }
}