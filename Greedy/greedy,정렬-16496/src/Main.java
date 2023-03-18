import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr.add(st.nextToken());
        }

        Collections.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        if(arr.get(0).equals("0")) {
            System.out.println(0);
            return;
        }

        String str = String.join("", arr);
        System.out.println(str);
    }
}