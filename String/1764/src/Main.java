import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hashSet = new HashSet<>();
        List<String> res = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(hashSet.contains(str))
                res.add(str);
        }

        Collections.sort(res);

        sb.append(res.size() + "\n");
        for(String str : res) {
            sb.append(str + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}