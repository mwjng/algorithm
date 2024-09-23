import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            routeX(i);
            routeY(i);
        }

        System.out.println(cnt);
    }

    public static void routeX(int x) {
        int count = 1;
        boolean down = false;
        for(int i = 1; i < N; i++) {
            if(Math.abs(map[x][i-1] - map[x][i]) > 1) {
                return;
            }
            else if(map[x][i-1] > map[x][i]) {
                if(down && count < L)
                    return;
                down = true;
                count = 1;
            }
            else if(map[x][i-1] < map[x][i]) {
                if(down) {
                    count -= L;
                }
                if(count < L) {
                    return;
                }
                else {
                    down = false;
                    count = 1;
                }
            }
            else
                count++;
        }

        if(down && count < L) {
            return;
        }
        cnt++;
    }

    public static void routeY(int y) {
        int count = 1;
        boolean down = false;
        for(int i = 1; i < N; i++) {
            if(Math.abs(map[i-1][y] - map[i][y]) > 1) {
                return;
            }
            else if(map[i-1][y] > map[i][y]) {
                if(down && count < L)
                    return;
                down = true;
                count = 1;
            }
            else if(map[i-1][y] < map[i][y]) {
                if(down) {
                    count -= L;
                }
                if(count < L) {
                    return;
                }
                else {
                    down = false;
                    count = 1;
                }
            }
            else
                count++;
        }

        if(down && count < L) {
            return;
        }
        cnt++;
    }
}