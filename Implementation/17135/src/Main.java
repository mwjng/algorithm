import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Coo {
    int x, y;
    Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M, D;
    static int[][] map;
    static List<Coo> coo = new ArrayList<>();
    static List<Coo> archer = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    coo.add(new Coo(i, j));
                }
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int depth) {
        if(depth == 3) {
            List<Coo> temp = new ArrayList<>();
            for(int i = 0; i < coo.size(); i++) {
                temp.add(new Coo(coo.get(i).x, coo.get(i).y));
            }
            max = Math.max(max, calc(temp));
            return;
        }
        for(int i = idx; i < M; i++) {
            archer.add(new Coo(N, i));
            dfs(i+1, depth+1);
            archer.remove(archer.size() - 1);
        }
    }

    public static int calc(List<Coo> copy) {
        int sum = 0;
        List<Coo> rm;
        while(!copy.isEmpty()) {
            rm = new ArrayList<>();
            for (Coo arch : archer) {
                Coo mc = new Coo(-1, -1);
                int min = Integer.MAX_VALUE;
                for (Coo cp : copy) {
                    int dist = distance(arch, cp);
                    if(dist <= D) {
                        if (min > dist || (min == dist && cp.y < mc.y)) {
                            min = dist;
                            mc = cp;
                        }
                    }
                }
                if(mc.x != -1) {
                    rm.add(mc);
                }
            }

            rm = rm.stream().distinct().collect(Collectors.toList());
            sum += rm.size();

            for(Coo c : copy) {
                if (c.x == N-1)
                    rm.add(c);
                else
                    c.x++;
            }

            copy.removeAll(rm);
        }

        return sum;
    }

    public static int distance(Coo c1, Coo c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }
}
