import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		int[] dp = new int[N+1];
		
		for (int i = 1; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for (int i = 1; i <= N; i++) {

			dp[i] = Math.max(dp[i], dp[i-1]);
			if (i+arr[i][0]-1> N) {
				continue;
			}
			if (dp[i+arr[i][0]-1] < dp[i-1]+arr[i][1]) {
				dp[i+arr[i][0]-1] = dp[i-1]+arr[i][1];
				max = Math.max(max, dp[i+arr[i][0]-1]);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}