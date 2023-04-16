import java.io.*;
import java.util.*;

class Coo {
    int x, y;
    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] board = new int[9][9];
    static List<Coo> coo = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            for(int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
                if(board[i][j] == 0) {
                    coo.add(new Coo(i, j));
                }
            }
        }

        dfs(0);
    }

    public static void dfs(int depth) {
        if(depth == coo.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        for(int j = 1; j <= 9; j++) {
            if(check(coo.get(depth).x, coo.get(depth).y, j)) {
                board[coo.get(depth).x][coo.get(depth).y] = j;
                dfs(depth + 1);
                board[coo.get(depth).x][coo.get(depth).y] = 0;
            }
        }
    }

    public static boolean check(int x, int y, int num) {
        for(int i = 0; i < 9; i++) {
            if(board[x][i] == num) return false;
            if(board[i][y] == num) return false;
        }
        int tx = x/3 * 3;
        int ty = y/3 * 3;
        for(int j = 0; j < 3; j++) {
            for(int k = 0; k < 3; k++) {
                if(board[tx+j][ty+k] == num)
                    return false;
            }
        }
        return true;
    }
}
