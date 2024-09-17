import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static int[][] board1, board2;
    static int[][] dw, db;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N+1][M+1];
        board1 = new int[N+1][M+1];
        board2 = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = input.charAt(j-1);
            }
        }
        dw = new int[N+1][M+1];
        db = new int[N+1][M+1];
        make('W', board1);
        make('B', board2);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dw[i][j] = dw[i-1][j] + dw[i][j-1] - dw[i-1][j-1] + board1[i][j];
                db[i][j] = db[i-1][j] + db[i][j-1] - db[i-1][j-1] + board2[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int w = dw[i+K-1][j+K-1] - dw[i+K-1][j-1] - dw[i-1][j+K-1] + dw[i-1][j-1];
                int b = db[i+K-1][j+K-1] - db[i+K-1][j-1] - db[i-1][j+K-1] + db[i-1][j-1];
                min = Math.min(min, Math.min(w, b));
            }
        }
        System.out.print(min);
    }

    static void make(char c, int[][] board) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(i % 2 != 0) {
                    if (j % 2 != 0 && arr[i][j] != c) {
                        board[i][j] = 1;
                    } else if(j % 2 == 0 && arr[i][j] == c) {
                        board[i][j] = 1;
                    }
                } else {
                    if(j % 2 == 0 && arr[i][j] != c) {
                        board[i][j] = 1;
                    } else if (j % 2 != 0 && arr[i][j] == c) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}