import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }
        int[] d = new int[N+1];
        d[M] = arr[M];
        for (int i = M+1; i <= N; i++) {
            d[i] = Math.max(d[i-1] + arr[i] - arr[i-1], arr[i] - arr[i-M]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = M; i <= N; i++) {
            max = Math.max(max, d[i]);
        }
        if(max < 0) System.out.print(0);
        else System.out.print(max);
    }
}