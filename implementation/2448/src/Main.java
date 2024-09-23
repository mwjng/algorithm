import java.io.*;

public class Main {
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        star = new char[N][2*N-1];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N-1; j++) {
                star[i][j] = ' ';
            }
        }

        draw(0, N-1, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 2*N-1; j++) {
                bw.write(star[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void draw(int x, int y, int n) {
        if(n == 3) {
            star[x][y] = '*';
            star[x+1][y-1] = star[x+1][y+1] = '*';
            star[x+2][y-2] = star[x+2][y-1] = star[x+2][y] = star[x+2][y+1] = star[x+2][y+2] = '*';
            return;
        }
        draw(x, y, n/2);
        draw(x+n/2, y-n/2, n/2);
        draw(x+n/2, y+n/2, n/2);
    }
}
