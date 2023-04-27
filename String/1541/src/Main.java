import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        List<String> s = new ArrayList<>();
        int total = 0;
        while (st.hasMoreTokens()) {
            s.add(st.nextToken());
        }
        for (int i = 0; i < s.size(); i++) {
            String sr = s.get(i);
            String[] array = sr.split("\\+");
            int sum = 0;
            for (String temp : array) {
                sum += Integer.parseInt(temp);
            }
            if (i == 0)
                total = sum;
            else
                total -= sum;
        }
        System.out.println(total);
    }
}