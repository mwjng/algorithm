import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 10;

        for (int t = 1; t <= T; t++) {
            int[] arr = new int[100];
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);
                arr[0] = arr[0] + 1;
                arr[99] = arr[99] - 1;
            }

            Arrays.sort(arr);
            int result = arr[99] - arr[0];
            bw.write("#" + t + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}