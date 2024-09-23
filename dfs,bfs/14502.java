import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> vx = new ArrayList<>();
    static List<Integer> vy = new ArrayList<>();
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    vx.add(i);
                    vy.add(j);
                }
            }
        }
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int count) {
        if(count == 3) {
            cnt = Math.max(cnt, bfs());
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static int bfs() {
        int count = 0;
        int[][] copy = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < vx.size(); i++) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{vx.get(i), vy.get(i)});
            while (!q.isEmpty()) {
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];
                for (int j = 0; j < 4; j++) {
                    int tX = x + dx[j];
                    int tY = y + dy[j];
                    if (tX >= 0 && tX < n && tY >= 0 && tY < m) {
                        if(copy[tX][tY] == 0) {
                            copy[tX][tY] = 2;
                            q.offer(new int[]{tX, tY});
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}