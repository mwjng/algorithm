import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] a1, a2, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        a1 = new int[N+1];
        a2 = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a1[Integer.parseInt(st.nextToken())] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a2[i] = a1[Integer.parseInt(st.nextToken())];
        }
        d = new int[N];
        d[0] = a2[1];
        int size = 1;
        for (int i = 2; i <= N; i++) {
            int idx = Arrays.binarySearch(d, 0, size, a2[i]);
            idx = -1 * idx - 1;
            if(idx == size) {
                d[size++] = a2[i];
            } else {
                d[idx] = a2[i];
            }
        }
        System.out.println(size);
    }
}