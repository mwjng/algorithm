import java.io.*;
import java.util.*;

class Client {
    int sx, sy, ex, ey;
    Client(int sx, int sy, int ex, int ey) {
        this.sx=sx;
        this.sy=sy;
        this.ex=ex;
        this.ey=ey;
    }
}
class Car implements Comparable<Car>{
    int x, y, dist;
    Car(int x, int y, int dist) {
        this.x=x;
        this.y=y;
        this.dist=dist;
    }

    @Override
    public int compareTo(Car o) {
        if(this.dist == o.dist) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        return this.dist - o.dist;
    }
}
public class Main {
    static int N, M, fuel, startX, startY;
    static int[][] map;
    static List<Client> clients = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken())-1;
        startY = Integer.parseInt(st.nextToken())-1;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            clients.add(new Client(Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1));
        }

        while(M-- > 0) {
            Client ct = bfs_start(startX, startY);
            if(ct == null) {
                System.out.println(-1);
                return;
            }
            clients.remove(ct);
            if(!bfs_end(ct.sx, ct.sy, ct)) {
                System.out.println(-1);
                return;
            }
        }

        bw.write(String.valueOf(fuel));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs_end(int x, int y, Client c) {
        if(x == c.ex && y == c.ey) {
            startX = x;
            startY = y;
            return true;
        }
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Car> q = new PriorityQueue<>();
        visit[x][y] = true;
        q.offer(new Car(x, y, 0));
        while(!q.isEmpty()) {
            Car car = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = car.x + dx[i];
                int ny = car.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1 && !visit[nx][ny]) {
                    if(nx == c.ex && ny == c.ey) {
                        fuel -= (car.dist+1);
                        if(fuel < 0) return false;
                        else {
                            fuel += (car.dist+1) * 2;
                            startX = c.ex;
                            startY = c.ey;
                            return true;
                        }
                    }
                    visit[nx][ny] = true;
                    q.offer(new Car(nx, ny, car.dist+1));
                }
            }
        }
        return false;
    }

    static Client bfs_start(int x, int y) {
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Car> q = new PriorityQueue<>();
        visit[x][y] = true;
        q.offer(new Car(x, y, 0));
        while(!q.isEmpty()) {
            Car car = q.poll();
            for(Client c : clients) {
                if(car.x == c.sx && car.y == c.sy) {
                    fuel -= car.dist;
                    if(fuel < 0)
                        return null;
                    return c;
                }
            }
            for(int i = 0; i < 4; i++) {
                int nx = car.x + dx[i];
                int ny = car.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] != 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.offer(new Car(nx, ny, car.dist+1));
                }
            }
        }
        return null;
    }
}