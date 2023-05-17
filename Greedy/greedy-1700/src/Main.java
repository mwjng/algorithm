import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static List<Integer> list = new ArrayList<>();
    static int[] arr;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K; i++) {
            if(!list.contains(arr[i])) {
                if (list.size() < N) {
                    list.add(arr[i]);
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    boolean check = false;
                    for(int j = i+1; j < K; j++) {
                        if(list.contains(arr[j]) && !temp.contains(arr[j])) {
                            temp.add(arr[j]);
                        }
                    }
                    for(int j = 0; j < list.size(); j++) {
                        if(!temp.contains(list.get(j))) {
                            list.remove(j);
                            res++;
                            list.add(arr[i]);
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        list.remove(temp.get(temp.size() - 1));
                        res++;
                        list.add(arr[i]);
                    }
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
