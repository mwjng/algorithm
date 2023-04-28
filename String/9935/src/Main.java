import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            boolean check = false;
            st.push(str.charAt(i));

            if(st.size() >= boom.length()) {
                for(int j = 0; j < boom.length(); j++) {
                    if(st.get(st.size() - boom.length() + j) != boom.charAt(j)) {
                        check = true;
                        break;
                    }
                }

                if(!check) {
                    for(int j = 0; j < boom.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        if(st.isEmpty()) {
            bw.write("FRULA");
        }
        else {
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
