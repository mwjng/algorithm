import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            if(max == d[i]) {
                stack.push(a[i]);
                max--;
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
