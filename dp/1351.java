import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static int P, Q;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        System.out.print(dfs(N));
    }

    static long dfs(long n) {
        if(map.containsKey(n)) return map.get(n);
        map.put(n, dfs(n/P) + dfs(n/Q));
        return map.get(n);
    }
}