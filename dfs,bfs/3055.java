import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hed;
    static List<int[]> water = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        hed = new int[2];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') {
                    hed[0] = i;
                    hed[1] = j;
                } else if (map[i][j] == '*') {
                    water.add(new int[]{i, j, 1});
                }
            }
        }
        int res = bfs();
        if(res == 0) System.out.println("KAKTUS");
        else System.out.println(res);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>(water);
        boolean[][] visited = new boolean[R][C];
        q.offer(new int[]{hed[0], hed[1], 0, 0});
        visited[hed[0]][hed[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C ) continue;
                if (cur[2] == 1) {
                    if(map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        q.offer(new int[]{nx, ny, 1});
                        map[nx][ny] = '*';
                    }
                }
                else if (cur[2] == 0) {
                    if(map[nx][ny] == 'D') return cur[3]+1;
                    if(map[nx][ny] != '.' || visited[nx][ny]) continue;
                    q.offer(new int[]{nx, ny, 0, cur[3]+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}