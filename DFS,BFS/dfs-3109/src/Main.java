import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static boolean check = false;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < r; i++) {
            check = false;
            dfs(i, 0);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for(int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(!visit[nx][ny] && map[nx][ny] == '.') {
                    dfs(nx, ny);
                    if(check) {
                        return;
                    }
                }
            }
        }

        if(y == c-1) {
            cnt++;
            check = true;
        }
    }
}
