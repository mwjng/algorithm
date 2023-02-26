import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < n; i++) {
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + cost[i][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(cost[n-1][0], cost[n-1][1]), cost[n-1][2]));

    }
}