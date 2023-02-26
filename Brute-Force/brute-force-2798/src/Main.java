import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < n-2; i++) {
          //if(num[i] > m - 2)
          //    continue;
            for(int j = i+1; j < n-1; j++) {
          //    if(num[i] + num[j] > m - 1)
          //        continue;
                for(int k = j+1; k < n; k++) {
                    int result = num[i] + num[j] + num[k];
                    if(result == m) {
                        sum = result;
                        break;
                    }
                    if(result < m && result > sum) {
                        sum = result;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}