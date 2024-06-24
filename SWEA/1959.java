import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int result;
            if (N <= M) {
                result = findMax(A, B);
            } else {
                result = findMax(B, A);
            }

            bw.write("#" + t + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int findMax(int[] a, int[] b) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= b.length - a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                sum += a[j]*b[j+i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}