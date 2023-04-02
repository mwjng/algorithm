import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        // 배열 중복 제거 방법 2가지

        // 1. LinkedHashSet
        /*LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(str));
        String[] res = linkedHashSet.toArray(String[]::new);*/

        // 2. Stream / distinct()
        String[] res = Arrays.stream(str).distinct().toArray(String[]::new);


        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
