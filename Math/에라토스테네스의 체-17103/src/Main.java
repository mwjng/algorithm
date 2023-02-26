import java.util.*;

public class Main {

   static boolean[] num = new boolean[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 소수는 false 아니면 true
        num[0] = num[1] = true;
        for(int i = 2; i*i <= 1000000; i++) {
            if(!num[i]) {
                for(int j = i+i; j <= 1000000; j+=i) {
                    num[j] = true;
                }
            }
        }

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            int cnt = 0;
            for(int j = 2; j <= temp/2; j++) {
                if((!num[j]) && (!num[temp - j])) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}