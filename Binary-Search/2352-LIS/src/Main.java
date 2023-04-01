import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lis = 0;
        for(int i = 0; i < n; i++) {
            int index = binarySearch(arr[i], 0, lis, lis+1);
            if(index == -1) {
                dp[lis++] = arr[i];
            }
            else {
                dp[index] = arr[i];
            }
        }

        System.out.println(lis);
    }

    public static int binarySearch(int num, int left, int right, int size) {
        int res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(num <= dp[mid]) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if(left == size) {
            return -1;
        }
        else {
            return res;
        }
    }
}