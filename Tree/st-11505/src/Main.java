import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, T;
    static int[] arr;
    static long[] tree;
    static int INF = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new long[4*N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, N-1, 1);

        T = M + K;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1) {
                update(0, N-1, 1, c, b-1);
                arr[b-1] = c;
            }
            else {
                sb.append(mul(0, N-1, 1, b-1, c-1) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) * init(mid+1, end, node*2+1) % INF;
    }

    public static long update(int start, int end, int node, int val, int idx) {
        if(idx < start || idx > end) return tree[node];
        if(start == end) return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node*2, val, idx) * update(mid+1, end, node*2+1, val, idx) % INF;
    }

    public static long mul(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return 1;
        if(left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return mul(start, mid, node*2, left, right) * mul(mid+1, end, node*2+1, left, right) % INF;
    }
}
