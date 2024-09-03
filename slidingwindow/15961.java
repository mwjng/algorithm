import java.util.*;
import java.io.*;

/**
 * 480ms
 */
public class Main {
    static int N, d, k, c;
    static int[] arr;
    static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        count = new int[d + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (++count[arr[i]] == 1) cnt++;
        }
        int max = cnt;
        if(count[c] == 0) max++;

        for (int i = 1; i < N; i++) {
            int rm = arr[i - 1];
            if(--count[rm] == 0) cnt--;
            if(++count[arr[(i+k-1)%N]] == 1) cnt++;
            int tmp = 0;
            if(count[c] == 0) tmp = 1;
            max = Math.max(max, cnt+tmp);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}