import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        long[] d = new long[5];
        if (arr[N] % 4 == 0) {
            if (arr[N] == 0) {
                long cnt = 0;
                for (int i = 1; i <= N; i++) {
                    if (arr[i] == 0) cnt++;
                }
                if (cnt >= 4) {
                    long res = (cnt-1) * (cnt-2) * (cnt-3) / 6;
                    System.out.print(res);
                    return;
                }
            } else {
                int sum = arr[N] / 4;
                d[0] = 1;
                for (int i = 1; i <= N; i++) {
                    if (arr[i] != 0 && arr[i] % sum == 0) {
                        int tmp = arr[i] / sum;
                        if (tmp >= 1 && tmp <= 4) {
                            d[tmp] += d[tmp-1];
                        }
                    }
                }
            }
        }
        System.out.print(d[3]);
    }
}