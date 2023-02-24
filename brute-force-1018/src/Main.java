import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int minCount = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i = 0; i < n; i++) {
            String in = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = in.charAt(j);
            }
        }

        int bn = n - 7;
        int bm = m - 7;

        for(int i = 0; i < bn; i++) {
            for(int j = 0; j < bm; j++) {
                find(i, j);
            }
        }
        System.out.println(minCount);
    }

    public static void find(int i, int j) {
        int count = 0;
        for(int a = i; a < i+8; a++) {
            if(a % 2 == 0) {
                for(int b = j; b < j + 8; b++) {
                    if(b % 2== 0) {
                        if (board[a][b] == 'W') count++;
                    }
                    else {
                        if (board[a][b] == 'B') count++;
                    }
                }
            }
            else {
                for(int b = j; b < j + 8; b++) {
                    if(b % 2== 0) {
                        if (board[a][b] == 'B') count++;
                    }
                    else {
                        if (board[a][b] == 'W') count++;
                    }
                }
            }
        }
        minCount = Math.min(Math.min(count, 64-count), minCount);
    }
}