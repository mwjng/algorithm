import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cleanUp, cleanDown;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < R; i++) {
            if(map[i][0] == -1) {
                cleanUp = i;
                cleanDown = i+1;
                break;
            }
        }

        while(T-- > 0) {
            map = spread();
            cleaner();
        }

        int sum = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum+2);
    }

    public static int[][] spread() {
        int[][] t_map = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                t_map[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -1)
                    continue;
                for(int k = 0; k < 4; k++) {
                    int tr = i + dx[k];
                    int tc = j + dy[k];
                    if(tr >= 0 && tc >= 0 && tr < R && tc < C) {
                        if(map[tr][tc] != -1) {
                            t_map[tr][tc] += map[i][j] / 5;
                            t_map[i][j] -= map[i][j] / 5;
                        }
                    }
                }
            }
        }
        return t_map;
    }

    public static void cleaner() {
        for(int i = cleanUp-1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }
        for(int i = 0; i < C-1; i++) {
            map[0][i] = map[0][i+1];
        }
        for(int i = 0; i < cleanUp; i++) {
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i = C-1; i > 1; i--) {
            map[cleanUp][i] = map[cleanUp][i-1];
        }
        map[cleanUp][1] = 0;

        for(int i = cleanDown+1; i < R-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for(int i = 0; i < C-1; i++) {
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i = R-1; i > cleanDown; i--) {
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i = C-1; i > 1; i--) {
            map[cleanDown][i] = map[cleanDown][i-1];
        }
        map[cleanDown][1] = 0;
    }
}