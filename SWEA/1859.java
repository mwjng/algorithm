import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static long result;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            result = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            int maxIdx;
            while(idx < N) {
                maxIdx = findMaxIdx(idx, N);
                for (int j = idx; j < maxIdx; j++) {
                    result += arr[maxIdx] - arr[j];
                }
                idx = maxIdx + 1;
            }
            bw.write("#" + i + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int findMaxIdx(int start, int end) {
        int max = -1;
        int idx = -1;
        for (int i = start; i < end; i++) {
            if (max <= arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}