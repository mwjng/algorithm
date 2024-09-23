import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] box;
    static int[][] tmt;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int cnt = 0;  // 익은 토마토
    static int count = 0;  // 안 익은 토마토
    static int days = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        tmt = new int[H*N*M][3];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1) {
                        tmt[cnt][0] = i;
                        tmt[cnt][1] = j;
                        tmt[cnt++][2] = k;
                    }
                    else if(box[i][j][k] == 0)
                        count++;
                }
            }
        }

        if(count == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    days = Math.max(box[i][j][k], days);
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days - 1);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < cnt; i++) {
            int z = tmt[i][0];
            int x = tmt[i][1];
            int y = tmt[i][2];
            q.offer(new int[] {z, x, y});
        }
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tz = tmp[0];
            int tx = tmp[1];
            int ty = tmp[2];
            for (int i = 0; i < 6; i++) {
                int nz = tz + dz[i];
                int nx = tx + dx[i];
                int ny = ty + dy[i];
                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M) {
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = box[tz][tx][ty] + 1;
                        q.offer(new int[]{nz, nx, ny});
                    }
                }
            }
        }
    }
}