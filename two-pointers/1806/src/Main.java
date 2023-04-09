import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int end = 0;

        for(int i = 0; i < N; i++) {
            while(sum < S && end < N) {
                sum += arr[end++];
            }
            if(sum >= S) {
                min = Math.min(end - i, min);
            }
            sum -= arr[i];
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(min);
    }
}
