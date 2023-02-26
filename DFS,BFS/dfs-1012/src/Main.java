import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int cnt = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j, map, visited, n, m);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y, int[][] map, boolean[][] visited, int n, int m) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int tX = x + dx[i];
            int tY = y + dy[i];
            if(tX >= 0 && tX < n && tY >= 0 && tY < m) {
                if(!visited[tX][tY] && map[tX][tY] == 1) {
                    dfs(tX, tY, map, visited, n, m);
                }
            }
        }
    }
}