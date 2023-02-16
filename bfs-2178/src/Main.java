import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String in = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = in.charAt(j) - '0';
            }
        }
        bfs(0, 0);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int spot[] = q.poll();
            for(int i = 0; i < 4; i++) {
                int nX = spot[0] + dx[i];
                int nY = spot[1] + dy[i];
                if(nX >=0 && nX < n && nY >=0 && nY < m) {
                    if(!visited[nX][nY] && map[nX][nY] == 1) {
                        q.offer(new int[]{nX, nY});
                        visited[nX][nY] = true;
                        map[nX][nY] = map[spot[0]][spot[1]] + 1;
                    }
                }
            }
        }
        System.out.println(map[n-1][m-1]);
    }
}