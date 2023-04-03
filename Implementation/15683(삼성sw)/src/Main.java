import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Coo {
    int cctv, x, y;
    Coo(int cctv, int x, int y) {
        this.cctv = cctv;
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] map, tmap;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Coo> c = new ArrayList<>();
    static List<Integer> arr = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) {
                    c.add(new Coo(map[i][j], i, j));
                }
            }
        }

        dfs(0);

        System.out.println(min);
    }

    public static void copy() {
        tmap = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                tmap[i][j] = map[i][j];
            }
        }
    }

    public static void dfs(int depth) {
        if(depth == c.size()) {
            copy();
            for(int i = 0; i < depth; i++) {
                direction(c.get(i), arr.get(i));
            }
            min = Math.min(min, blind());
            return;
        }
        for(int j = 0; j < 4; j++) {
            arr.add(j);
            dfs(depth+1);
            arr.remove(depth);
        }
    }

    public static void direction(Coo c, int d) {

        switch (c.cctv) {
            case 1:
                if(d == 0) watch(c, 0);
                else if(d == 1) watch(c, 1);
                else if(d == 2) watch(c, 2);
                else watch(c, 3);
                break;
            case 2:
                if(d == 0 || d == 2) {
                    watch(c, 0);
                    watch(c, 2);
                }
                else {
                    watch(c, 1);
                    watch(c, 3);
                }
                break;
            case 3:
                if(d == 0) {
                    watch(c, 0);
                    watch(c, 1);
                }
                else if(d == 1) {
                    watch(c, 1);
                    watch(c, 2);
                }
                else if(d == 2) {
                    watch(c, 2);
                    watch(c, 3);
                }
                else {
                    watch(c, 3);
                    watch(c, 0);
                }
                break;
            case 4:
                if(d == 0) {
                    watch(c, 0);
                    watch(c, 1);
                    watch(c, 2);
                }
                else if(d == 1) {
                    watch(c, 1);
                    watch(c, 2);
                    watch(c, 3);
                }
                else if(d == 2) {
                    watch(c, 2);
                    watch(c, 3);
                    watch(c, 0);
                }
                else if(d == 3) {
                    watch(c, 3);
                    watch(c, 0);
                    watch(c, 1);
                }
                break;
            case 5:
                watch(c, 0);
                watch(c, 1);
                watch(c, 2);
                watch(c, 3);
                break;
        }
    }

    public static void watch(Coo c, int d) {
        int x = c.x;
        int y = c.y;
        while(true) {
            x += dx[d];
            y += dy[d];
            if(x >= 0 && y >= 0 && x < N && y < M) {
                if(tmap[x][y] == 6)
                    break;
                else if(tmap[x][y] == 0) {
                    tmap[x][y] = -1;
                }
            }
            else
                break;
        }
    }

    public static int blind() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmap[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
