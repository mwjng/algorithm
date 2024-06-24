import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[N-1-j][i]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(arr[N-1-i][N-1-j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(arr[j][N-1-i]);
                }
                sb.append("\n");
            }
            bw.write("#" + t + "\n");
            bw.write(String.valueOf(sb));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}