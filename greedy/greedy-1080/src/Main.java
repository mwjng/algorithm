import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] df;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] tmp = new int[N][M];
        df = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                tmp[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                df[i][j] = Math.abs((input.charAt(j) - '0') - tmp[i][j]);
            }
        }

        if(N < 3 || M < 3) {
            if(!compare()) {
                System.out.println(-1);
                return;
            }
            System.out.println(count);
            return;
        }

        for(int i = 0; i < N-2; i++) {
            for(int j = 0; j < M-2; j++) {
                if(df[i][j] == 1) {
                    change(i, j);
                    count++;
                }
            }
        }

        if(compare()) {
            System.out.println(count);
        }
        else
            System.out.println(-1);

    }

    public static void change(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                df[i][j] = df[i][j] == 1 ? 0 : 1;
            }
        }
    }

    public static boolean compare() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(df[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}