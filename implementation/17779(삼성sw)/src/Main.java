import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int total = 0;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for(int x = 1; x <= N; x++) {
            for(int y = 1; y <= N; y++) {
                for(int d1 = 1; d1 < N; d1++) {
                    for(int d2 = 1; d2 < N; d2++) {
                        if(x+d1+d2 > N)
                            continue;
                        if(y-d1 < 1 || y+d2 > N)
                            continue;
                        res = Math.min(res, calc(x, y, d1, d2));
                    }
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calc(int x, int y, int d1, int d2) {
        int[] sum = new int[5];
        boolean[][] border = new boolean[N+1][N+1];

        for(int i = 0; i <= d1; i++) {
            border[x+i][y-i] = true;
            border[x+d2+i][y+d2-i] = true;
        }
        for(int i = 0; i <= d2; i++) {
            border[x+i][y+i] = true;
            border[x+d1+i][y-d1+i] = true;
        }
        for(int r = 1; r < x+d1; r++) {
            for(int c = 1; c <= y; c++) {
                if(border[r][c])
                    break;
                sum[0] += map[r][c];
            }
        }
        for(int r = 1; r <= x+d2; r++) {
            for(int c = N; c > y; c--) {
                if(border[r][c])
                    break;
                sum[1] += map[r][c];
            }
        }
        for(int r = x+d1; r <= N; r++) {
            for(int c = 1; c < y-d1+d2; c++) {
                if(border[r][c])
                    break;
                sum[2] += map[r][c];
            }
        }
        for(int r = N; r > x+d2; r--) {
            for(int c = N; c >= y-d1+d2; c--) {
                if(border[r][c])
                    break;
                sum[3] += map[r][c];
            }
        }

        sum[4] = total-(sum[0]+sum[1]+sum[2]+sum[3]);
        Arrays.sort(sum);

        return sum[4] - sum[0];
    }
}