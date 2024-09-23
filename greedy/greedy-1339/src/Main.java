import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ap = new int[26];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                ap[input.charAt(j) - 'A'] += (int)Math.pow(10, input.length() - 1 - j);
            }
        }

        int sum = 0;
        int num = 9;
        Arrays.sort(ap);

        for(int i = ap.length-1; i >= 0; i--) {
            if(ap[i] == 0)
                break;
            sum += ap[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}