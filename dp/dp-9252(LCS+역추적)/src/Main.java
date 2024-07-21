import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Coo {
    char c; // 두 문자열에서 공통으로 등장한 문자
    int n;  // 현재까지 찾은 최대 공통 부분 문자열의 길이
    int x, y; // 현재까지 찾은 최대 공통 부분 문자열의 끝 위치
    Coo(char c, int n, int x, int y) {
        this.c = c;
        this.n = n;
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = str1.length();
        int m = str2.length();
        int[][] d = new int[n+1][m+1];
        List<Coo> temp = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1] + 1;
                    temp.add(new Coo(str1.charAt(i-1), d[i][j], i, j));
                }
                else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
                }
            }
        }

        System.out.println(d[n][m]);

        if(d[n][m] != 0) {
            Stack<Character> stack = new Stack<>();
            int common = d[n][m];
            int tx = -1;
            int ty = -1;
            for (int i = temp.size() - 1; i >= 0; i--) {
                if (temp.get(i).n == common && temp.get(i).x != tx && temp.get(i).y != ty) {
                    stack.push(temp.get(i).c);
                    common--;
                    tx = temp.get(i).x;
                    ty = temp.get(i).y;
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}
