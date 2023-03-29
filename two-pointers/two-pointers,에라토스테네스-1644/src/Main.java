import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n+1];
        List<Integer> arr = new ArrayList<>();

        check[0] = check[1] = true;
        for(int i = 2; i*i <= n; i++) {
            if(!check[i]) {
                for(int j = i*2; j <= n; j+=i) {
                    check[j] = true;
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            if(!check[i]) {
                arr.add(i);
            }
        }

        int sum = 0;
        int count = 0;
        int end = 0;

        for(int i = 0; i < arr.size(); i++) {
            while(end < arr.size() && sum < n) {
                sum += arr.get(end);
                end++;
            }
            if(sum == n) {
                count++;
            }
            sum -= arr.get(i);
        }

        System.out.println(count);

    }
}