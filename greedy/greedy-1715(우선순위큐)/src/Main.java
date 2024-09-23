import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            q.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while(q.size() > 1) {
            long a = q.poll();
            long b = q.poll();
            sum += a + b;
            q.offer(a + b);
        }

        System.out.println(sum);
    }
}
