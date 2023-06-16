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
    static List<Coo> virus = new ArrayList<>();
    static int res = Integer.MAX_VALUE;
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

        if(res == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(res-3));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int idx) {
        if(depth == M) {
            int value = bfs();
            if(value != -1) {
                res = Math.min(res, value);
            }
            return;
        }
        for(int i = idx; i < list.size(); i++) {
            virus.add(list.get(i));
            dfs(depth+1, i+1);
            virus.remove(virus.size()-1);
        }
    }

    public static int bfs() {
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        Queue<Coo> q = new LinkedList<>();
        for(Coo c : virus) {
            copy[c.x][c.y] = 3;
            q.offer(c);
        }

        while(!q.isEmpty()) {
            Coo tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                int tx = tmp.x + dx[i];
                int ty = tmp.y + dy[i];
                if(tx >= 0 && ty >= 0 && tx < N && ty < N) {
                    if(copy[tx][ty] == 0 || copy[tx][ty] == 2) {
                        copy[tx][ty] = copy[tmp.x][tmp.y] + 1;
                        q.offer(new Coo(tx, ty));
                    }
                }
            }
        }

        int max = 3;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(copy[i][j] == 0)
                    return -1;
                if(map[i][j] != 2) {
                    max = Math.max(max, copy[i][j]);
                }
            }
        }

        return max;
    }
}