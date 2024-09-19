import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int idx, value;
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    static int N, M;
    static int[] arr;
    static Node[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new Node[N * 4];
        init(1, N, 1);
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 1) update(1, N, 1, a, b);
            else sb.append(query(1, N, 1, a, b).idx + "\n");
        }
        System.out.print(sb);
    }

    static Node init(int start, int end, int node) {
        if(start == end) return tree[node] = new Node(start, arr[start]);
        int mid = (start+end)/2;
        Node a = init(start, mid, node * 2);
        Node b = init(mid+1, end, node*2+1);
        if(a.value == b.value) return tree[node] = a.idx < b.idx ? a : b;
        return tree[node] = a.value < b.value ? a : b;
    }

    static Node update(int start, int end, int node, int idx, int v) {
        if(idx < start || idx > end) return tree[node];
        if(start == end) return tree[node] = new Node(start, v);
        int mid = (start+end)/2;
        Node a = update(start, mid, node * 2, idx, v);
        Node b = update(mid+1, end, node*2+1, idx, v);
        if(a.value == b.value) return tree[node] = a.idx < b.idx ? a : b;
        return tree[node] = a.value < b.value ? a : b;
    }

    static Node query(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return new Node(0, Integer.MAX_VALUE);
        if(left <= start && right >= end) return tree[node];
        int mid = (start+end)/2;
        Node a = query(start, mid, node * 2, left, right);
        Node b = query(mid + 1, end, node * 2 + 1, left, right);
        if(a.value == b.value) return a.idx < b.idx ? a : b;
        return a.value < b.value ? a : b;
    }
}