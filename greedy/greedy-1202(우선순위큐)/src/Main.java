import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Gem implements Comparable<Gem> {
    int m, v;
    Gem(int m, int v) {
        this.m = m;
        this.v = v;
    }
    public int compareTo(Gem gem) {
        if(this.v == gem.v) {
            return this.m - gem.m;
        }
        return gem.v - this.v;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Gem[] gem = new Gem[N];
        int[] bag = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gem[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gem, new Comparator<Gem>() {
            public int compare(Gem a, Gem b) {
                return a.m - b.m;
            }
        });

        Arrays.sort(bag);

        PriorityQueue<Gem> pq = new PriorityQueue<>();

        long value = 0;
        int idx = 0;

        for(int i = 0; i < K; i++) {
           while(idx < N && bag[i] >= gem[idx].m) {
               pq.offer(gem[idx]);
               idx++;
           }
           if(!pq.isEmpty()) {
               value += pq.poll().v;
           }
        }

        System.out.println(value);
    }
}
