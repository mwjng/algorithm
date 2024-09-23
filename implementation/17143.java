import java.io.*;
import java.util.*;

class Fish {
    int r, c, s, d, z;
    boolean live;
    Fish(int r, int c, int s, int d, int z, boolean live) {
        this.r=r;
        this.c=c;
        this.s=s;
        this.d=d;
        this.z=z;
        this.live = live;
    }
}
class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int R, C, M;
    static Fish[] fishes;
    static int result = 0;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fishes = new Fish[M+1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            fishes[i] = new Fish(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken()), true);
        }

        map = new int[R+1][C+1];
        for(int i = 1; i < fishes.length; i++) {
            map[fishes[i].r][fishes[i].c] = i;
        }
        for(int i = 1; i <= R; i++) {
            if(map[i][1] != 0) {
                result += fishes[map[i][1]].z;
                fishes[map[i][1]].live = false;
                break;
            }
        }

        for(int i = 2; i <= C; i++) {
            map = new int[R+1][C+1];
            for(int j = 1; j < fishes.length; j++) {
                if(fishes[j].live) {
                    moveFish(fishes[j], j);
                }
            }
            for(int j = 1; j <= R; j++) {
                if(map[j][i] != 0) {
                    result += fishes[map[j][i]].z;
                    fishes[map[j][i]].live = false;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void moveFish(Fish fish, int idx) {
        fish.r = fish.r + dx[fish.d] * fish.s;
        fish.c = fish.c + dy[fish.d] * fish.s;
        while(fish.r < 1 || fish.r > R || fish.c < 1 || fish.c > C) {
            if (fish.r > R) {
                fish.d = 0;
                fish.r = R - (fish.r - R);
            } else if (fish.r < 1) {
                fish.d = 1;
                fish.r = 1 + (1 - fish.r);
            } else if (fish.c > C) {
                fish.d = 3;
                fish.c = C - (fish.c - C);
            } else {
                fish.d = 2;
                fish.c = 1 + (1 - fish.c);
            }
        }
        if(map[fish.r][fish.c] == 0)
            map[fish.r][fish.c] = idx;
        else
            eatFish(fish, fishes[map[fish.r][fish.c]], idx);
    }

    static void eatFish(Fish fish1, Fish fish2, int idx) {
        if (fish1.z > fish2.z) {
            map[fish2.r][fish2.c] = idx;
            fish2.live = false;
        } else {
            fish1.live = false;
        }
    }
}