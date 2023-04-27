import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] d = new int[10001];

        Arrays.fill(d, Integer.MAX_VALUE - 1);

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        d[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = arr[i]; j <= k; j++) {
                d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }

        if(d[k] == Integer.MAX_VALUE - 1)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(d[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
