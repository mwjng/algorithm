import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static List<int[]> list = new ArrayList<>();
    static int cnt, sum, res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visit = new boolean[N][N];
            boolean check = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visit[i][j]) {
                        sum = 0;
                        cnt = 0;
                        dfs(i, j);
                        if(cnt > 1) {
                            check = true;
                            calc(sum/cnt, list);
                        }
                        list.clear();
                    }
                }
            }

            if(check)
                res++;
            else
                break;
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        sum += map[x][y];
        cnt++;
        list.add(new int[]{x, y});
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visit[nx][ny]) {
                    int diff = Math.abs(map[x][y]-map[nx][ny]);
                    if(diff >= L && diff <= R) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }

    public static void calc(int value, List<int[]> list) {
        for(int[] temp : list) {
            map[temp[0]][temp[1]] = value;
        }
    }
}