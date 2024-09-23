import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    int s, t;
    Lecture(int s, int t) {
        this.s = s;
        this.t = t;
    }
    public int compareTo(Lecture r) {
        if(this.s == r.s)
            return this.t - r.t;
        return this.s - r.s;
    }
}
public class Main {
    static int N;
    static Lecture[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Lecture[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(s, t);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].t);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= arr[i].s) {
                pq.poll();
            }
            pq.offer(arr[i].t);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
