import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] d = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; i++) {
            d[n-1][i] = triangle[n-1][i];
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n-i; j++) {
                d[n-i][j] = Math.max(d[n-i+1][j], d[n-i+1][j+1]) + triangle[n-i][j];
            }
        }
        System.out.println(d[0][0]);
    }
}