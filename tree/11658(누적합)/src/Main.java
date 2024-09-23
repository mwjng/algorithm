import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        d = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = d[i][j-1] + map[i][j];
            }
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(n == 1) {
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int sum = 0;
                for(int i = x; i <= x2; i++) {
                    sum += d[i][y2] - d[i][y-1];
                }
                sb.append(sum + "\n");
            }
            else {
                int c = Integer.parseInt(st.nextToken());
                int diff = map[x][y] - c;
                map[x][y] = c;
                for(int i = y; i <= N; i++) {
                    d[x][i] -= diff;
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
