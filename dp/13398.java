import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] d = new int[n][2];
        d[0][0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(d[i-1][0] + arr[i], arr[i]);
            d[i][1] = Math.max(d[i-1][1] + arr[i], d[i-1][0]);
            max = Math.max(max, Math.max(d[i][0], d[i][1]));
        }
        System.out.print(max);
    }
}