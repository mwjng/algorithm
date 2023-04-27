import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] num = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp >= 'a') {
                num[tmp - 'a']++;
            }
            else {
                num[tmp - 'A']++;
            }
        }

        int count = 0;
        int max = 0;
        int idx = 0;
        for(int i = 0; i < num.length; i++) {
            if(max < num[i]) {
                max = num[i];
                idx = i;
                count = 0;
            }
            else if(max == num[i]) {
                count++;
            }
        }

        if(count > 0) {
            System.out.println("?");
        }
        else {
            char res = (char)(idx + 'A');
            System.out.println(res);
        }
    }
}
