import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] d = new int[15][15];

            for(int i = 1; i < 15; i++) {
                d[0][i] = i;
                d[i][1] = 1;
            }

            for(int i = 1; i <= k; i++) {
                for(int j = 2; j <= n; j++) {
                    d[i][j] = d[i][j-1] + d[i-1][j];
                }
            }

            System.out.println(d[k][n]);
        }

    }
}