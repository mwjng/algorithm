import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        Integer[] diff = new Integer[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);

        for(int i = 0; i < N-1; i++) {
            diff[i] = value[i+1] - value[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for(int i = 0; i < N-K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}