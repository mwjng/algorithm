import java.io.*;
import java.util.*;

public class Main {

    static int N, res = Integer.MIN_VALUE;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(0, N-1, 1);
        calc(0, N - 1);
        System.out.println(res);
    }

    static int init(int start, int end, int node) {
        if(start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        int leftIdx = init(start, mid, node * 2);
        int rightIdx = init(mid + 1, end, node * 2 + 1);
        return tree[node] = arr[leftIdx] > arr[rightIdx] ? rightIdx : leftIdx;
    }

    static int query(int start, int end, int node, int left, int right) {
        if(left > end || right < start) return -1;
        if(left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        int leftIdx = query(start, mid, node * 2, left, right);
        int rightIdx = query(mid + 1, end, node * 2 + 1, left, right);
        if(leftIdx == -1) return rightIdx;
        else if(rightIdx == -1) return leftIdx;
        return arr[leftIdx] > arr[rightIdx] ? rightIdx : leftIdx;
    }

    static void calc(int left, int right) {
        int idx = query(0, N-1, 1, left, right);
        res = Math.max(res, (right - left + 1) * arr[idx]);
        if(left <= idx-1) calc(left, idx-1);
        if(right >= idx+1) calc(idx+1, right);
    }
}