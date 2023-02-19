import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, cnt = 0;
        while(n > 0) {
            String in = Integer.toString(n);
            if (in.length() < 3) {
                cnt += n;
                System.out.println(cnt);
                break;
            } else {
                int a = in.charAt(0) - '0';
                int b = in.charAt(1) - '0';
                int sum = a - b;
                for (i = 1; i < in.length() - 1; i++) {
                    int temp = in.charAt(i) - in.charAt(i + 1);
                    if (sum != temp) {
                        i = -1;
                        break;
                    }
                }
                if(i > 0)
                    cnt++;
                n--;
            }
        }
    }
}