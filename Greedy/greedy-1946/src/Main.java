import java.util.*;

class Grade implements Comparable<Grade>{
    int a, b;
    public Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int compareTo(Grade g) {
        return this.a - g.a;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            List<Grade> score = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                score.add(new Grade(sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(score);
            int cnt = 1;
            int k = score.get(0).b;
            for(int i = 1 ; i < N; i++) {
                if(k > score.get(i).b) {
                    cnt++;
                    k = score.get(i).b;
                }
            }

            System.out.println(cnt);
        }
    }
}