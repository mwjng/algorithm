import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long min = N;
        int[] room = new int[N];
        for(int i = 0; i < N; i++) {
            room[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();

        for(int i = 0; i < N; i++) {
            room[i] -= B;
            if(room[i] > 0) {
                if (room[i] % C == 0)
                    min += room[i] / C;
                else
                    min += room[i] / C + 1;
            }
        }

        System.out.println(min);
    }
}