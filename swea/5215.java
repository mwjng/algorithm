import java.io.*;
import java.util.*;

class Ingt {
	int score, cal;
	Ingt(int score, int cal) {
		this.score = score;
		this.cal = cal;
	}
}
public class Solution {
	static int N, L, max, sum;
	static Ingt[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new Ingt[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				arr[i] = new Ingt(score, cal);
			}
			
			max = Integer.MIN_VALUE;
			sum = 0;
			
			dfs(0,0);
			
			bw.write("#" + t + " " + max + "\n");
		}
        bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int cal) {
		if(cal > L) {
			max = Math.max(max, sum - arr[idx-1].score);
			return;
		}
		if(idx == N) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = idx; i < N; i++) {
			sum += arr[i].score;
			dfs(i+1, cal + arr[i].cal);
			sum -= arr[i].score;
		}
	}
}