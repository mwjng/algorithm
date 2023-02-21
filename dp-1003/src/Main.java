import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] array0 = new int[41];
            int[] array1 = new int[41];
            array0[0] = 1;
            array1[0] = 0;
            array0[1] = 0;
            array1[1] = 1;
            for(int i = 2; i <= n; i++) {
                array0[i] = array0[i-2] + array0[i-1];
                array1[i] = array1[i-2] + array1[i-1];
            }
            System.out.println(array0[n] + " " + array1[n]);
        }
    }
}