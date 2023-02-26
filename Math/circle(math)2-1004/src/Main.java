import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int cnt = 0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int n = sc.nextInt();
            int[] cx = new int[n];
            int[] cy = new int[n];
            int[] r = new int[n];
            for(int i = 0; i < n; i++) {
                cx[i] = sc.nextInt();
                cy[i] = sc.nextInt();
                r[i] = sc.nextInt();
                int distance1 = (int)(Math.pow(x1 - cx[i], 2) + Math.pow(y1 - cy[i], 2));
                int distance2 = (int)(Math.pow(x2 - cx[i], 2) + Math.pow(y2 - cy[i], 2));

                if(distance1 > Math.pow(r[i], 2) && distance2 < Math.pow(r[i], 2))
                    cnt++;
                else if(distance1 < Math.pow(r[i], 2) && distance2 > Math.pow(r[i], 2))
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}