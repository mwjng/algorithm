import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i = 0; i < N; i++) {
            int temp = binarySearch(arr[i], idx);
            if(temp == -1) {
                d[idx++] = arr[i];
            }
            else {
                d[temp] = arr[i];
            }
        }

        bw.write(String.valueOf(arr.length - idx));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int n, int idx) {
        int left = 0;
        int right = idx - 1;
        int res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(d[mid] > n) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if(right == idx - 1) {
            return -1;
        }
        return res;
    }
}
