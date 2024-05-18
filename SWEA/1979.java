import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
		
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			List<int[]> h = new ArrayList<>();
			List<int[]> v = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {
						if(j == 0 || arr[i][j-1] == 0) {
							h.add(new int[] {i, j});
						}
						if(i == 0 || arr[i-1][j] == 0) {
							v.add(new int[] {i, j});
						}
					}
				}
			}
			
			int result = 0;
			for(int[] tmp : h) {
				int cnt = 0;
				for(int i = tmp[1]; i < N; i++) {
					if(arr[tmp[0]][i] == 0)
						break;
					cnt++;
				}
				if(cnt == K)
					result++;
			}
			
			for(int[] tmp : v) {
				int cnt = 0;
				for(int i = tmp[0]; i < N; i++) {
					if(arr[i][tmp[1]] == 0)
						break;
					cnt++;
				}
				if(cnt == K)
					result++;
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
        bw.flush();
		bw.close();
		br.close();
	}
}