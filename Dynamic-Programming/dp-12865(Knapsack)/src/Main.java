import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] d = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] v = new int[N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                d[i][j] = d[i-1][j];
                if(j >= w[i]) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        bw.write(String.valueOf(d[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
