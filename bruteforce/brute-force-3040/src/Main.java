import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> num = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            num.add(sc.nextInt());
            sum += num.get(i);
        }
        sum -= 100;

        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                int total = num.get(i) + num.get(j);
                if(sum == total) {
                    for(int n : num) {
                        if(n != num.get(i) && n != num.get(j))
                            System.out.println(n);
                    }
                    return;
                }
            }
        }
    }
}