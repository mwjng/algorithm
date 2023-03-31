import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for(int i = 0; i < N/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        int min = N;
        int count = 0;

        Arrays.sort(down);
        Arrays.sort(up);

        for(int i = 1; i <= H; i++) {
            int cnt = binarySearch(0, N/2, down, i) + binarySearch(0, N/2, up, H-i+1);
            if(min == cnt) {
                count++;
            }
            else if(min > cnt) {
                min = cnt;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    public static int binarySearch(int left, int right, int[] arr, int h) {
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= h) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return arr.length - right;
    }
}