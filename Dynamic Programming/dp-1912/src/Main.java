import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        d[0] = array[0];
        for(int i = 1; i < n; i++) {
            d[i] = Math.max(d[i-1] + array[i], array[i]);
        }
        int max = d[0];
        for(int i = 1; i < n; i++) {
            if(max < d[i])
                max = d[i];
        }
        System.out.println(max);
    }
}