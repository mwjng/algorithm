import java.io.*;
import java.util.*;

class Main {
    static int[][] board = new int[20][20];
    static int[] dx = {1, 0, 1, -1};
    static int[] dy = {0, 1, 1, 1};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int check = 0;

        for(int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                if (board[j][i] == 1 || board[j][i] == 2) {
                    int stn = board[j][i];
                    for(int k = 0; k < 4; k++) {
                        int cnt = 0;
                        int x = j;
                        int y = i;
                        while (x >= 1 && y >= 1 && x <= 19 && y <= 19) {
                            if (board[x][y] != stn)
                                break;
                            x += dx[k];
                            y += dy[k];
                            cnt++;
                        }
                        if (cnt == 5) {
                            int tx = j - dx[k];
                            int ty = i - dy[k];
                            if(tx >= 1 && ty >= 1 && tx <= 19 && ty <= 19 && board[tx][ty] != stn) {
                                sb.append(stn + "\n").append(j + " " + i);
                                check = 1;
                                break;
                            }
                            if(tx < 1 || ty < 1 || tx > 19 || ty > 19) {
                                sb.append(stn + "\n").append(j + " " + i);
                                check = 1;
                                break;
                            }
                        }
                    }
                    if(check == 1)
                        break;
                }
            }
            if(check == 1)
                break;
        }

        if(check == 0) {
            bw.write(String.valueOf(0));
        } else {
            bw.write(String.valueOf(sb));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}