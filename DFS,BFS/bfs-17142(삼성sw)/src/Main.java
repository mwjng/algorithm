import java.io.*;
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
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Coo> list = new ArrayList<>();
    static List<Integer> virus = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    list.add(new Coo(i, j));
                }
            }
        }

        dfs(0, 0);

        if(min == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int idx) {
        if(depth == M) {
            int res = bfs();
            if(res != -1) {
                min = Math.min(min, res);
            }
            return;
        }
        for(int i = idx; i < list.size(); i++) {
            virus.add(i);
            dfs(depth+1, i+1);
            virus.remove(Integer.valueOf(i));
        }
    }

    public static int bfs() {
        Queue<Coo> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        for(int i = 0; i < M; i++) {
            int idx = virus.get(i);
            Coo c = list.get(idx);
            q.offer(new Coo(c.x, c.y));
            visit[c.x][c.y] = true;
            copy[c.x][c.y] = 3;
        }
        while(!q.isEmpty()) {
            Coo c = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
                    if(copy[nx][ny] != 1) {
                        copy[nx][ny] = copy[c.x][c.y] + 1;
                        visit[nx][ny] = true;
                        q.offer(new Coo(nx, ny));
                    }
                }
            }
        }

        int max = 3;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(copy[i][j] == 0 || copy[i][j] == 2)
                    return -1;
                if(copy[i][j] != 1 && map[i][j] != 2)
                    max = Math.max(max, copy[i][j]);
            }
        }

        return max-3;
    }
}
