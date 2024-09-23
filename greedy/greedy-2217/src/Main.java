import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> rope = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            rope.add(sc.nextInt());
        }

        Collections.sort(rope, Collections.reverseOrder());
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int weight = rope.get(i);
            int total = weight * (i+1);
            max = Math.max(total, max);
        }

        System.out.println(max);
    }
}