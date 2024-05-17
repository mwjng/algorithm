import java.io.*;
import java.util.*;

class Coo {
    int x, y;

    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int N, cnt;
    static Coo[] queen;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            queen = new Coo[N];
            dfs(0);

            bw.write("#" + t + " " + cnt + "\n");
            cnt = 0;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (possible(depth, i)) {
                queen[depth] = new Coo(depth, i);
                dfs(depth+1);
            }
        }
    }

    static boolean possible(int depth, int i) {
        for (int j = 0; j < depth; j++) {
            if (i == queen[j].y || Math.abs(depth - queen[j].x) == Math.abs(i - queen[j].y)) {
                return false;
            }
        }
        return true;
    }
}