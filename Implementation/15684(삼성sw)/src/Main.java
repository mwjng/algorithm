import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] check;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        check = new boolean[H+1][N+2];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = true;
        }

        dfs(0, 1, 1);

        if(min == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int x, int y) {
        if(chk()) {
            min = Math.min(min, depth);
            return;
        }
        if(depth == 3)
            return;
        for(int i = x; i < N; i++) {
            if(x == i) {
                for (int j = y; j <= H; j++) {
                    if (!check[j][i - 1] && !check[j][i] && !check[j][i + 1]) {
                        check[j][i] = true;
                        dfs(depth + 1, i, j + 1);
                        check[j][i] = false;
                    }
                }
            }
            else {
                for (int j = 1; j <= H; j++) {
                    if (!check[j][i - 1] && !check[j][i] && !check[j][i + 1]) {
                        check[j][i] = true;
                        dfs(depth + 1, i, y + 1);
                        check[j][i] = false;
                    }
                }
            }
        }
    }

    public static boolean chk() {
        for(int i = 1; i <= N; i++) {
            int res = i;
            for(int j = 1; j <= H; j++) {
                if(check[j][res]) {
                    res += 1;
                }
                else if(check[j][res-1]) {
                    res -= 1;
                }
            }
            if(res != i)
                return false;
        }
        return true;
    }
}
