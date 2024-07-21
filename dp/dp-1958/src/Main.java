import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        int[][][] d = new int[n+1][m+1][l+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                for(int k = 1; k <= l; k++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1) && s1.charAt(i-1) == s3.charAt(k-1)) {
                        d[i][j][k] = d[i-1][j-1][k-1] + 1;
                    }
                    else {
                        d[i][j][k] = Math.max(Math.max(d[i-1][j][k], d[i][j-1][k]), d[i][j][k-1]);
                    }
                }
            }
        }

        bw.write(String.valueOf(d[n][m][l]));
        bw.flush();
        bw.close();
        br.close();
    }
}
