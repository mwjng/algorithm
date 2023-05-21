import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[10][10];
    static int[] paper = {5, 5, 5, 5, 5};
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if(res == Integer.MAX_VALUE)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int depth) {
        if(x == 9 && y > 9) {
            res = Math.min(res, depth);
            return;
        }
        if(depth >= res)
            return;
        if(y > 9) {
            dfs(x+1, 0, depth);
            return;
        }
        if(map[x][y] == 1) {
            for(int i = 5; i >= 1; i--) {
                if(paper[i-1] > 0 && isAttach(x, y, i)) {
                    attach(x, y, i, 0);
                    paper[i-1]--;
                    dfs(x, y+i, depth+1);
                    attach(x, y, i, 1);
                    paper[i-1]++;
                }
            }
        }
        else {
            dfs(x, y+1, depth);
        }
    }

    public static void attach(int x, int y, int size, int state) {
        for(int i = x; i < x+size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int x, int y, int size) {
        for(int i = x; i < x+size; i++) {
            for(int j = y; j <y+size; j++) {
                if(i >= 0 && j >= 0 && i < 10 && j < 10) {
                    if(map[i][j] == 0) {
                        return false;
                    }
                }
                else
                    return false;
            }
        }

        return true;
    }
}
