import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        h = new int[n];

        for(int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(h);

        int low = 1;
        int high = h[n-1] - h[0] + 1;

        while(low < high) {
            int mid = (low + high) / 2;

            if(install(mid) < c) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    public static int install(int distance) {
        int count = 1;
        int last = h[0];

        for(int i = 1; i < h.length; i++) {
            if(h[i] - last >= distance) {
                last = h[i];
                count++;
            }
        }

        return count;
    }
}