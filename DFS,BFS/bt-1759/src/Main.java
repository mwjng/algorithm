import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static String vows = "aeiou";
    static List<String> con = new ArrayList<>();
    static List<String> vow = new ArrayList<>();
    static List<String> temp = new ArrayList<>();
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            String ap = st.nextToken();
            if(vows.contains(ap))
                vow.add(ap);
            else
                con.add(ap);
        }

        for(int i = 1; i <= L-2; i++) {
            vowDfs(i, 0, 0);
        }

        Collections.sort(result);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void vowDfs(int depth, int index, int cnt) {
        if(cnt == depth) {
            conDfs(L-depth, 0, 0);
            return;
        }
        for(int i = index; i < vow.size(); i++) {
            temp.add(vow.get(i));
            vowDfs(depth, i+1, cnt+1);
            temp.remove(vow.get(i));
        }
    }

    public static void conDfs(int depth, int index, int cnt) {
        if(cnt == depth) {
            Collections.sort(temp);
            String str = String.join("", temp);
            result.add(str);
            return;
        }
        for(int i = index; i < con.size(); i++) {
            temp.add(con.get(i));
            conDfs(depth, i+1, cnt+1);
            temp.remove(con.get(i));
        }
    }
}
