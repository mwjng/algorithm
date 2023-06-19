import java.util.*;

class Solution {
    static String[] arr;
    static Set<Integer> prime = new HashSet<>();
    static boolean[] check;
    public int solution(String numbers) {
        arr = new String[numbers.length()];
        check = new boolean[numbers.length()];

        for(int i = 0; i < numbers.length(); i++) {
            arr[i] = String.valueOf(numbers.charAt(i));
        }

        for(int i = 0; i < arr.length; i++) {
            dfs(i, arr[i], 1);
        }

        int answer = prime.size();
        return answer;
    }

    public static void dfs(int idx, String str, int depth) {
        if(depth == arr.length) {
            int num = Integer.parseInt(str);
            if(isPrime(num))
                prime.add(num);
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(i != idx && !check[i]) {
                check[i] = true;
                dfs(idx, str + arr[i], depth+1);
                check[i] = false;
                dfs(idx, str, depth+1);
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}