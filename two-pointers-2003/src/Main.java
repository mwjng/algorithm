import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];

        int cnt = 0;
        int end = 0;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            while(end < n && sum < m) {
                sum += num[end];
                end++;
            }
            if(sum == m) {
                cnt++;
            }
            sum -= num[i];
        }
        System.out.println(cnt);
    }
}