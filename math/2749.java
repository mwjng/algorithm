import java.util.*;
import java.io.*;

public class Main {
    static long INF = (long)1e6;
    static long n;
    static long[][] m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        m = new long[][]{{1, 1}, {1, 0}};
        long f0 = 0;
        long f1 = 1;
        long[][] pow = matrix_pow(m, n);
        System.out.print((pow[1][0]*f1 + pow[1][1]*f0)%INF);
    }

    static long[][] matrix_pow(long[][] mtx, long exp) {
        if(exp == 1) return mtx;
        long[][] tmp = matrix_pow(mtx, exp/2);
        if (exp % 2 == 0) return multi(tmp, tmp);
        else return multi(multi(tmp, tmp), m);
    }

    static long[][] multi(long[][] mtx1, long[][] mtx2) {
        int len = mtx1.length;
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += mtx1[i][k] * mtx2[k][j];
                }
                res[i][j] %= INF;
            }
        }
        return res;
    }
}