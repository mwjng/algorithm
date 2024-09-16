import java.util.*;
import java.io.*;

public class Main {
    static final int INF = (int) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][2];
        if(N == 1) {
            System.out.println(2);
            return;
        }
        d[0][0] = 0;
        d[1][0] = 2;
        d[2][0] = 7;
        d[2][1] = 1;
        for (int i = 3; i <= N; i++) {
            d[i][1] = (d[i-1][1] + d[i-3][0]) % INF;
            d[i][0] = (d[i-1][0]*2 + d[i-2][0]*3 + d[i][1]*2) % INF;
        }
        System.out.print(d[N][0]);
    }
}