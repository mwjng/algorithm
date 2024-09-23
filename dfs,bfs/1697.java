import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int n;
    public static int k;
    public static int x;
    public static int[] visited = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs(n);
        System.out.println(visited[x]-1);
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.offer(n);
        while(!q.isEmpty()) {
            x = q.poll();
            if(x == k)
                return;
            int a = x-1;
            int b = x+1;
            int c = x*2;
            if (a >= 0 && a <= 100000 && visited[a] == 0) {
                visited[a] = visited[x] + 1;
                q.offer(a);
            }
            if (b >= 0 && b <= 100000 && visited[b] == 0) {
                visited[b] = visited[x] + 1;
                q.offer(b);
            }
            if (c >= 0 && c <= 100000 && visited[c] == 0) {
                visited[c] = visited[x] + 1;
                q.offer(c);
            }
        }
    }
}