import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int max, chance;
    static boolean isOdd;
    static int[] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            arr = new int[input.length()];
            for (int j = 0; j < input.length(); j++) {
                arr[j] = input.charAt(j) - '0';
            }
            chance = Integer.parseInt(st.nextToken());

            if(arr.length < chance) {
                boolean dup = Arrays.stream(arr)
                        .distinct()
                        .count() != arr.length;
                if (!dup) {
                    isOdd = (chance - arr.length) % 2 != 0;
                }
                chance = arr.length;
            }
            dfs(0, 0);

            if (isOdd) {
                String[] sp = String.valueOf(max).split("");
                String temp = sp[arr.length - 1];
                sp[arr.length - 1] = sp[arr.length - 2];
                sp[arr.length - 2] = temp;
                max = Integer.parseInt(String.join("", sp));
            }

            bw.write("#" + i + " " + max + "\n");
            max = 0;
            isOdd = false;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int depth) {
        if (depth == chance) {
            String result = Arrays.stream(arr)
                    .mapToObj(n -> String.valueOf(n))
                    .collect(Collectors.joining(""));
            max = Math.max(max, Integer.parseInt(result));
            return;
        }
        for (int i = start; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(i, j);
                dfs(i, depth+1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}