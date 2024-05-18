import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Character.getNumericValue(input.charAt(j));
//                    arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
//                    arr[i][j] = input.charAt(j) - '0';
                }
            }
            int mid = N / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (i <= mid) {
                    for (int j = mid - i; j <= mid + i; j++) {
                        sum += arr[i][j];
                    }
                } else {
                    for (int j = i - mid; j < mid + N - i; j++) {
                        sum += arr[i][j];
                    }
                }
            }

            bw.write("#" + t + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}