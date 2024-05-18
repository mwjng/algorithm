import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			arr[0][0] = 1;
			for(int i = 1; i < N; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
			}
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			bw.write("#" + t + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] != 0) {
						bw.write(arr[i][j] + " ");
					}
				}
				bw.write("\n");
			}
		}
        bw.flush();
		bw.close();
		br.close();
	}
}