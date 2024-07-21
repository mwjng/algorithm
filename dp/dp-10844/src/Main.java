import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N+1][10];

        for(int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    d[i][j] = d[i-1][j+1] % MOD;
                }
                else if(j == 9) {
                    d[i][j] = d[i-1][j-1] % MOD;
                }
                else {
                    d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % MOD;
                }

            }
        }

        long res = 0;
        for(int i = 0; i < 10; i++) {
            res += d[N][i];
        }
        bw.write(String.valueOf(res % MOD));
        bw.flush();
        bw.close();
        br.close();
    }
}