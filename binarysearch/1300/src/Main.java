import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(binarySearch(1, k));
    }

    public static long binarySearch(long left, long right) {
        while(left < right) {
            long cnt = 0;
            long mid = (left + right) / 2;
            for(int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }
            if(cnt >= k) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
