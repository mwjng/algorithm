import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] a, d, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        d = new int[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(d, Integer.MIN_VALUE);

        int lis = 0;

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(a[i], 0, lis, lis+1);
            if(idx == -1) {
                d[lis++] = a[i];
                arr[i] = lis;
            }
            else {
                d[idx] = a[i];
                arr[i] = idx + 1;
            }
        }

        System.out.println(lis);

        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            if(lis == arr[i]) {
                stack.push(a[i]);
                lis--;
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    public static int binarySearch(int num, int left, int right, int size) {
        int res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(num <= d[mid]) {
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        if(left == size)
            return -1;
        return res;
    }
}
