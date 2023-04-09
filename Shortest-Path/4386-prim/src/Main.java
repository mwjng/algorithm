import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Coo {
    double x, y;
    Coo(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class Star implements Comparable<Star>{
    int idx;
    double dist;
    Star(int idx, double dist) {
        this.idx = idx;
        this.dist = dist;
    }
    public int compareTo(Star s) {
        return (int)(this.dist - s.dist);
    }
}
public class Main {
    static int N;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        Coo[] coo = new Coo[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coo[i] = new Coo(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        List<Star>[] list = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                list[i].add(new Star(j, distance(coo[i], coo[j])));
            }
        }

        double res = 0;
        PriorityQueue<Star> pq = new PriorityQueue<>();
        pq.offer(new Star(0, 0));
        while(!pq.isEmpty()) {
            Star tmp = pq.poll();
            if(!check[tmp.idx]) {
                check[tmp.idx] = true;
                res += tmp.dist;
                for (int i = 0; i < list[tmp.idx].size(); i++) {
                    if (!check[list[tmp.idx].get(i).idx]) {
                        pq.offer(list[tmp.idx].get(i));
                    }
                }
            }
        }

        System.out.printf("%.2f", res);
    }

    public static double distance(Coo c1, Coo c2) {
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }
}
