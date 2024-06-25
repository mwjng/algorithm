import java.io.*;
import java.util.*;

class Solution {
    static int N, M, max;
    static int[][] arr;
    static int[] pdx = {-1, 1, 0, 0};
    static int[] pdy = {0, 0, -1, 1};
    static int[] mdx = {-1, -1, 1, 1};
    static int[] mdy = {-1, 1, -1, 1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, calc(i, j));
                }
            }

            bw.write("#" + t + " "  + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int calc(int x, int y) {
        return Math.max(plus(x, y), multi(x, y));
    }

    static int plus(int x, int y) {
        int sum = arr[x][y];
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                int tx = x + pdx[j]*i;
                int ty = y + pdy[j]*i;
                if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    sum += arr[tx][ty];
                }
            }
        }
        return sum;
    }

    static int multi(int x, int y) {
        int sum = arr[x][y];
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                int tx = x + mdx[j]*i;
                int ty = y + mdy[j]*i;
                if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                    sum += arr[tx][ty];
                }
            }
        }
        return sum;
    }
}