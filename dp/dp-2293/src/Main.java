import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] d = new int[10001];

        d[0] = 1;
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j <= k; j++) {
                d[j] = d[j] + d[j - arr[i]];
            }
        }

        bw.write(String.valueOf(d[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
