import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tree = new int[4*N];

        init(0, N-1, 1);

        int[] res = new int[N];
        for(int i = 1; i <= N; i++) {
            int index = query(0, N-1, 1, Integer.parseInt(br.readLine()));
            res[index] = i;
            update(0, N-1, 1, index);
        }

        for(int i = 0; i < N; i++) {
            bw.write(res[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = 1;
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static void update(int start, int end, int node, int idx) {
        if(idx < start || idx > end) return;
        tree[node]--;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node*2, idx);
        update(mid+1, end, node*2+1, idx);
    }

    public static int query(int start, int end, int node, int val) {
        if(start == end) return start;
        int mid = (start + end) / 2;
        if(tree[node*2] > val)
            return query(start, mid, node*2, val);
        else
            return query(mid+1, end, node*2+1, val - tree[node*2]);
    }
}
