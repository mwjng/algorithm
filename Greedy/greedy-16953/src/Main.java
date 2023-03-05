import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 1;

        while(a != b) {
            if(b < a) {
                System.out.println(-1);
                return;
            }
            else if(b % 10 == 1) {
                b /= 10;
                cnt++;
            }
            else if(b % 2 == 0) {
                b /= 2;
                cnt++;
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}