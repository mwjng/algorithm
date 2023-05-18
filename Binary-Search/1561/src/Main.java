import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        if(N <= M) {
            bw.write(String.valueOf(N));
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        long time = binarySearch(0, (long)N/M*max);
        long res = M;
        for(int i = 1; i <= M; i++) {
            res += (time - 1) / arr[i];
        }
        for(int i = 1; i <= M; i++) {
            if(time % arr[i] == 0) {
                res++;
            }
            if(res == N) {
                bw.write(String.valueOf(i));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
    }

    public static long binarySearch(long left, long right) {
        while(left < right) {
            long mid = (left + right) / 2;
            long sum = M;
            for(int i = 1; i <= M; i++) {
                sum += mid / arr[i];
            }
            if(sum >= N)
                right = mid;
            else
                left = mid+1;
        }

        return right;
    }
}
