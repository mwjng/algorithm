import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] s;
    static int[] cnt;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new long[N+1];
        cnt = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            s[i] = (s[i-1] + Integer.parseInt(st.nextToken())) % M;
            int idx = (int)s[i];
            if(idx == 0) res++;
            cnt[idx]++;
        }

        for(int i = 0; i < M; i++) {
            res += (long)cnt[i] * (cnt[i] - 1) / 2;
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
