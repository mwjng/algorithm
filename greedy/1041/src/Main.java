import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] num = new long[3];
        num[0] = (long)Math.pow(N-2, 2) + (long)(N-2)*(N-1)*4;
        num[1] = (long)(N-1)*4 + (long)(N-2)*4;
        num[2] = 4;

        long sum = 0;
        if(N == 1) {
            Arrays.sort(arr);
            for(int i = 0; i < 5; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
            return;
        }

        int[] min = new int[3];
        min[0] = Math.min(arr[0], arr[5]);
        min[1] = Math.min(arr[1], arr[4]);
        min[2] = Math.min(arr[2], arr[3]);

        Arrays.sort(min);

        sum = num[0]*min[0] + num[1]*(min[0]+min[1]) + num[2]*(min[0]+min[1]+min[2]);

        System.out.println(sum);
    }
}