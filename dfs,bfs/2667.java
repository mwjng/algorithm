import java.util.*;

public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n];
        map = new int[n][n];
        List<Integer> array = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String in = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = in.charAt(j) - '0';
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    int result = bfs(i, j);
                    array.add(result);
                }
            }
        }

        Collections.sort(array);
        System.out.println(array.size());
        for(int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tX = temp[0];
            int tY = temp[1];
            for(int i = 0; i < 4; i++) {
                int nX = tX + dx[i];
                int nY = tY + dy[i];
                if(nX >= 0 && nX < n && nY >= 0 && nY < n) {
                    if (!visited[nX][nY] && map[nX][nY] == 1) {
                        q.offer(new int[]{nX, nY});
                        visited[nX][nY] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}