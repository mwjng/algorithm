import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            //String[] str = input.split("\\[|\\]|,");

            if(p.contains("D") && input.length() == 2) {
                sb.append("error" + "\n");
                continue;
            }

            input = input.substring(1, input.length() - 1);
            String[] str = input.split(",");

            boolean check = false;
            boolean reverse = false;

            List<String> list = new ArrayList<>();
            for(int i = 0; i < str.length; i++) {
                list.add(str[i]);
            }

            for(int i = 0; i < p.length(); i++) {
                if(p.charAt(i) == 'R') {
                    reverse = !reverse;
                }
                else {
                    if(list.isEmpty()) {
                        check = true;
                        break;
                    }

                    if(reverse)
                        list.remove(list.size()-1);
                    else
                        list.remove(0);
                }
            }

            if(check) {
                sb.append("error" + "\n");
                continue;
            }

            String res;
            if(!reverse) {
                 res = String.join(",", list);
            }
            else {
                List<String> rlist = new ArrayList<>();
                for(int i = list.size()-1; i >= 0; i--) {
                    rlist.add(list.get(i));
                }
                res = String.join(",", rlist);
            }

            sb.append("[" + res + "]" + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
