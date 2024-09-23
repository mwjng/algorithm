import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, minTree, maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        minTree = new int[4*N];
        maxTree = new int[4*N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        maxInit(0, N-1, 1);
        minInit(0, N-1, 1);

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(minFind(0, N-1, 1, a, b) + " " + maxFind(0, N-1, 1, a, b) + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int maxInit(int start, int end, int node) {
        if(start == end) return maxTree[node] = arr[start];
        int mid = (start + end) / 2;
        return maxTree[node] = Math.max(maxInit(start, mid, node*2), maxInit(mid+1, end, node*2+1));
    }

    public static int minInit(int start, int end, int node) {
        if(start == end) return minTree[node] = arr[start];
        int mid = (start + end) / 2;
        return minTree[node] = Math.min(minInit(start, mid, node*2), minInit(mid+1, end, node*2+1));
    }

    public static int maxFind(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return Integer.MIN_VALUE;
        if(left <= start && right >= end) return maxTree[node];
        int mid = (start + end) / 2;
        return Math.max(maxFind(start, mid, node*2, left, right), maxFind(mid+1, end, node*2+1, left, right));
    }

    public static int minFind(int start, int end, int node, int left, int right) {
        if(right < start || left > end) return Integer.MAX_VALUE;
        if(left <= start && right >= end) return minTree[node];
        int mid = (start + end) / 2;
        return Math.min(minFind(start, mid, node*2, left, right), minFind(mid+1, end, node*2+1, left, right));
    }
}
