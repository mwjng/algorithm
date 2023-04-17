import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[][] d = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            d[i][i] = true;
        }

        for(int i = 0; i < N-1; i++) {
            if(arr[i] == arr[i+1]) {
                d[i][i+1] = true;
            }
        }

        for(int i = 2; i < N; i++) {
            for(int j = 0; j < N-i; j++) {
                if(arr[j] == arr[j+i] && d[j+1][j+i-1]) {
                    d[j][j+i] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            if (d[s][e]) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb);
    }
}
