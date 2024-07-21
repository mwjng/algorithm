import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] m, c;
    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        d = new int[10001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 10000; j >= c[i]; j--) {
                d[j] = Math.max(d[j], d[j - c[i]] + m[i]);
            }
        }

        int res = 0;
        for(int i = 0; i <= 10000; i++) {
            if(d[i] >= M) {
                res = i;
                break;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}