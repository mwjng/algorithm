import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] p = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + arr[i][j];
                }
            }

            int max = Integer.MIN_VALUE;
            int sum;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    sum = p[i][j] - p[i-M][j] - p[i][j-M] + p[i-M][j-M];
                    max = Math.max(max, sum);
                }
            }
            bw.write("#" + t + " " + max + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}