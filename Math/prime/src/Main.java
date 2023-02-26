import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

   public static int n;
   public static int[] a = new int[100];
   public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            if(is_prime(a[i]))
                cnt++;
        }

        System.out.println(cnt);

    }

    public static boolean is_prime(int x) {
        if(x < 2)
            return false;
        for(int i = 2; i*i <= x; i++) {
            if(x%i == 0)
                return false;
        }
        return true;
    }

}