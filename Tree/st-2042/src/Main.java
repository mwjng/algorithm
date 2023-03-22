import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        tree = new long[N*4];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0, N-1, 1);

        int T = M + K;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                update(0, N-1, 1, b-1, c - arr[b-1]);
                arr[b-1] = c;
            }
            else if(a == 2){
                System.out.println(sum(0, N-1, 1, b-1, (int)c-1));
            }
        }
    }

    public static long init(int start, int end, int node) {
        if(start == end) {
            tree[node] = arr[start];
            return tree[node];
        }
        int mid = (start + end) / 2;
        tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
        return tree[node];
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if(right < start || left > end) {
            return 0;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    public static void update(int start, int end, int node, int index, long diff) {
        if(index < start || index > end) {
            return;
        }
        tree[node] += diff;
        if(start == end) {
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node*2, index, diff);
        update(mid+1, end, node*2+1, index, diff);
    }
}