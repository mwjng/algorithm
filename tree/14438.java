import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr, tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new int[N * 4];
        init(0, N-1, 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 1) update(0, N-1, 1, a-1, b);
            else sb.append(query(0, N-1, 1, a-1, b-1) + "\n");
        }
        System.out.print(sb);
    }

    static int init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    static int update(int start, int end, int node, int idx, int v) {
        if(idx < start || idx > end) return tree[node];
        if(start == end) return tree[node] = v;
        int mid = (start+end)/2;
        return tree[node] = Math.min(update(start, mid, node*2, idx, v),
                update(mid+1, end, node*2+1, idx, v));
    }

    static int query(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return Integer.MAX_VALUE;
        if(left <= start && right >= end) return tree[node];
        int mid = (start+end)/2;
        return Math.min(query(start, mid, node*2, left, right),
                query(mid+1, end, node*2+1, left, right));
    }
}