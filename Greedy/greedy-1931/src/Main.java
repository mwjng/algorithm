import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Meeting> p = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            p.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(p);

        int end = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(end <= p.get(i).start) {
                end = p.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
class Meeting implements Comparable<Meeting> {
    int start;
    int end;
    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int compareTo(Meeting m) {
        if(this.end == m.end) return this.start - m.start;
        return this.end - m.end;
    }
}