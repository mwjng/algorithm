import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] d = new int[N+1];
        d[N] = -1;
        for (int i = N - 1; i >= 1; i--) {
            if(arr[i] < arr[i+1]) {
                d[i] = arr[i+1];
                continue;
            }
            int idx = 1;
            while (true) {
                if(d[i+idx] == -1) {
                    d[i] = -1;
                    break;
                }
                if(arr[i] < d[i+idx]) {
                    d[i] = d[i+idx];
                    break;
                }
                idx++;
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(d[i] + " ");
        }
        System.out.print(sb);
    }
}