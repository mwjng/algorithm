import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!dq.isEmpty() && dq.peekLast()[0] <= i-L) {
                dq.pollLast();
            }
            while (!dq.isEmpty() && num <= dq.peekFirst()[1]) {
                dq.pollFirst();
            }
            dq.addFirst(new int[]{i, num});
            bw.write(dq.peekLast()[1] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}