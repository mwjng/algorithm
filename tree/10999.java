import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, a, b, c;
    static long[] arr, tree, lazy;
    static long d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N*4];
        lazy = new long[N*4];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(0, N-1, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            if (a == 1) {
                d = Long.parseLong(st.nextToken());
                update(0, N-1, 1, b, c, d);
            } else {
                sb.append(sum(0, N-1, 1, b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void updateLazy(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node] * (end - start + 1);
            if(start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static long sum(int start, int end, int node, int left, int right) {
        updateLazy(start, end, node);
        if(right < start || left > end) return 0;
        if(left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) +
                sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static long update(int start, int end, int node, int left, int right, long diff) {
        updateLazy(start, end, node);
        if(right < start || left > end) return tree[node];
        if (left <= start && right >= end) {
            tree[node] += diff * (end - start + 1);
            if (start != end) {
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return tree[node];
        }
        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, left, right, diff) +
                update(mid + 1, end, node * 2 + 1, left, right, diff);
    }
}