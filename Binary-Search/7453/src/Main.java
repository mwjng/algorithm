import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a, b, c, d;
    static int[] ab, cd;
    static long cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        ab = new int[n*n];
        cd = new int[n*n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx++] = c[i] + d[j];
            }
        }

        Arrays.sort(cd);

        for(int i = 0; i < ab.length; i++) {
            int num = -ab[i];
            cnt += (binarySearch_upper(num) - binarySearch_lower(num));
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch_lower(int num) {
        int left = 0;
        int right = cd.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(cd[mid] >= num)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    public static int binarySearch_upper(int num) {
        int left = 0;
        int right = cd.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(cd[mid] > num)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}
