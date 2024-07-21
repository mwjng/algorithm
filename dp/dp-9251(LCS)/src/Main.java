import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = str1.length();
        int m = str2.length();
        int[][] d = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
                }
            }
        }

        System.out.println(d[n][m]);
    }
}
