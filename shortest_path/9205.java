import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] d, map;
    static final int MAX = Integer.MAX_VALUE >> 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            d = new int[n+2][n+2];
            map = new int[n+2][2];
            for (int i = 0; i < n+2; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    if(i == j) continue;
                    d[i][j] = getDistance(map[i][0], map[i][1], map[j][0], map[j][1]);
                    if(d[i][j] > 1000) d[i][j] = MAX;
                }
            }
            for (int k = 0; k < n + 2; k++) {
                for (int i = 0; i < n + 2; i++) {
                    if(k == i) continue;
                    for (int j = 0; j < n + 2; j++) {
                        if(i == j || j == k) continue;
                        if (d[i][j] > d[i][k] + d[k][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }
            if(d[0][n+1] == MAX) sb.append("sad").append("\n");
            else sb.append("happy").append("\n");
        }
        System.out.println(sb);
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}