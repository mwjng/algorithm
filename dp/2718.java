import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] d = new int[N+1];
            if (N == 1) {
                sb.append(1 + "\n");
                continue;
            }
            d[0] = 1;
            d[1] = 1;
            d[2] = 5;
            for (int i = 3; i <= N; i++) {
                d[i] = d[i-1] + d[i-2]*4;
                for (int j = 3; j <= i; j++) {
                    if (j % 2 == 0) d[i] += d[i-j]*3;
                    else d[i] += d[i-j]*2;
                }
            }
            sb.append(d[N] + "\n");
        }
        System.out.print(sb);
    }
}