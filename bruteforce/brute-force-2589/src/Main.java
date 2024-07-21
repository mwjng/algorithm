import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Coo {
    int x, y;
    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Coo> list = new ArrayList<>();
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'L') {
                    list.add(new Coo(i, j));
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            res = Math.max(res, bfs(list.get(i).x, list.get(i).y));
        }

        System.out.println(res);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[][] check = new int[N][M];
        q.offer(new int[] {x, y});
        check[x][y] = 1;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tx = tmp[0];
            int ty = tmp[1];
            for(int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(map[nx][ny] == 'L' && check[nx][ny] == 0) {
                        check[nx][ny] = check[tx][ty] + 1;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            max = Math.max(max, check[list.get(i).x][list.get(i).y]);
        }
        return max - 1;
    }
}
