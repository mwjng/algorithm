import java.io.*;
import java.util.*;

class Shark {
    int x, y, dict;

    public Shark(int x, int y, int dict) {
        this.x = x;
        this.y = y;
        this.dict = dict;
    }
}
class Fish {
    int x, y, num, dict;
    boolean isAlive;

    public Fish(int x, int y, int num, int dict, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.dict = dict;
        this.isAlive = isAlive;
    }
}
public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][] arr = new int[4][4];
    static int max = 0;
    static List<Fish> fishes = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dict = Integer.parseInt(st.nextToken()) - 1;
                fishes.add(new Fish(i, j, num, dict, true));
                arr[i][j] = num;
            }
        }

        Collections.sort(fishes, (o1, o2) -> o1.num - o2.num);

        Fish fish = fishes.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, fish.dict);
        fish.isAlive = false;
        arr[0][0] = -1;

        dfs(shark, fish.num, fishes, arr);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(Shark shark, int sum, List<Fish> fishes, int[][] arr) {
        if (max < sum) {
            max = sum;
        }

        for (Fish fish : fishes) {
            moveFish(fish, fishes, arr);
        }

        for (int i = 1; i < 4; i++) {
            int nx = shark.x + dx[shark.dict] * i;
            int ny = shark.y + dy[shark.dict] * i;

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] > 0) {
                int[][] copy = arrCopy(arr);
                List<Fish> copyList = copyFishes(fishes);

                Fish f = copyList.get(copy[nx][ny] - 1);
                Shark newShark = new Shark(nx, ny, f.dict);

                copy[shark.x][shark.y] = 0;
                copy[nx][ny] = -1;
                f.isAlive = false;

                dfs(newShark, sum + f.num, copyList, copy);
            }
        }
    }

    static void moveFish(Fish fish, List<Fish> fishes, int[][] arr) {
        if(!fish.isAlive)
            return;
        for (int i = 0; i < 8; i++) {
            int nextDict = (fish.dict + i) % 8;
            int nx = fish.x + dx[nextDict];
            int ny = fish.y + dy[nextDict];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arr[nx][ny] > -1) {
                fish.dict = nextDict;
                arr[fish.x][fish.y] = 0;
                if (arr[nx][ny] != 0) {
                    Fish tmp = fishes.get(arr[nx][ny] - 1);
                    tmp.x = fish.x;
                    tmp.y = fish.y;
                    arr[fish.x][fish.y] = tmp.num;
                }

                fish.x = nx;
                fish.y = ny;
                arr[nx][ny] = fish.num;

                return;
            }
        }
    }

    static int[][] arrCopy(int[][] arr) {
        int[][] copy = new int[4][4];
        for(int i = 0; i < 4; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }

    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        fishes.forEach(fish -> temp.add(new Fish(fish.x, fish.y, fish.num, fish.dict, fish.isAlive)));

        return temp;
    }
}