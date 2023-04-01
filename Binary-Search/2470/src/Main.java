import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int diff = Integer.MAX_VALUE;

        int res1 = 0;
        int res2 = 0;

        while(left < right) {
            int sum = arr[left] + arr[right];
            int tmp = Math.abs(sum);
            if(tmp < diff) {
                diff = tmp;
                res1 = arr[left];
                res2 = arr[right];
            }
            if(sum > 0) {
                right--;
            }
            else if(sum < 0) {
                left++;
            }
            else
                break;
        }

        System.out.println(res1 + " " + res2);
    }
}