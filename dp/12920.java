import java.util.*;
import java.io.*;

public class Main {
    static class Item {
        int w, v;
        Item(int w, int v) {
            this.w=w;
            this.v=v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int cnt = 1;
            while (cnt <= K) {
                items.add(new Item(V*cnt, C*cnt));
                K -= cnt;
                cnt *= 2;
            }
            if(K > 0) items.add(new Item(V*K, C*K));
        }
        int[][] d = new int[M+1][items.size()+1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= items.size(); j++) {
                d[i][j] = d[i][j-1];
                if(i >= items.get(j-1).w) {
                    d[i][j] = Math.max(d[i][j], d[i-items.get(j-1).w][j-1] + items.get(j-1).v);
                }
            }
        }
        System.out.print(d[M][items.size()]);
    }
}