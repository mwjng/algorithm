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
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2;
        }
        tree = new int[N * 4];
        init(1, N, 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            if (o == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())%2;
                if(arr[a] != b) {
                    update(1, N, 1, a, arr[a]-b);
                    arr[a]=b;
                }
            } else if(o == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(b-a+1-query(1, N, 1, a, b) + "\n");
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(query(1, N, 1, a, b) + "\n");
            }
        }
        System.out.print(sb);
    }

    static int init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    static void update(int start, int end, int node, int idx, int diff) {
        if(idx < start || idx > end) return;
        tree[node] -= diff;
        if(start == end) return;
        int mid = (start+end)/2;
        update(start, mid, node*2, idx, diff);
        update(mid+1, end, node*2+1, idx, diff);
    }

    static int query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return 0;
        if(left <= start && right >= end) return tree[node];
        int mid = (start+end)/2;
        return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
    }
}