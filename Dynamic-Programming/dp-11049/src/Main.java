import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][2];
        int[][] d = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N-i; j++) {
                d[j][j+i] = Integer.MAX_VALUE;
                for(int k = 0; k < i; k++) {
                    int cnt = d[j][j+k] + d[j+k+1][j+i] + a[j][0] * a[j+k][1] * a[j+i][1];
                    d[j][j+i] = Math.min(d[j][j+i], cnt);
                }
            }
        }

        bw.write(String.valueOf(d[0][N-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}
