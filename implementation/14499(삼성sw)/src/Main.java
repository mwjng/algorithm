import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int x, y;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] cmd;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cmd = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        if(map[x][y] != 0) {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        for(int i = 0; i < K; i++) {
            int tx = x + dx[cmd[i]];
            int ty = y + dy[cmd[i]];
            if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
                dice = move(tx, ty, cmd[i]);
                System.out.println(dice[0]);
                x = tx;
                y = ty;
            }
        }
    }

    public static int[] move(int x, int y, int dict) {
        int[] t_dice = new int[6];
        for(int i = 0; i < 6; i++) {
            t_dice[i] = dice[i];
        }
        switch(dict) {
            case 1:
                t_dice[0] = dice[3];
                t_dice[1] = dice[1];
                t_dice[2] = dice[0];
                t_dice[3] = dice[5];
                t_dice[4] = dice[4];
                t_dice[5] = dice[2];
                break;
            case 2:
                t_dice[0] = dice[2];
                t_dice[1] = dice[1];
                t_dice[2] = dice[5];
                t_dice[3] = dice[0];
                t_dice[4] = dice[4];
                t_dice[5] = dice[3];
                break;
            case 3:
                t_dice[0] = dice[4];
                t_dice[1] = dice[0];
                t_dice[2] = dice[2];
                t_dice[3] = dice[3];
                t_dice[4] = dice[5];
                t_dice[5] = dice[1];
                break;
            case 4:
                t_dice[0] = dice[1];
                t_dice[1] = dice[5];
                t_dice[2] = dice[2];
                t_dice[3] = dice[3];
                t_dice[4] = dice[0];
                t_dice[5] = dice[4];
                break;
        }
        if(map[x][y] == 0) {
            map[x][y] = t_dice[5];
        }
        else {
            t_dice[5] = map[x][y];
            map[x][y] = 0;
        }
        return t_dice;
    }
}