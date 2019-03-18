import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int[] quality = new int[N];
        for (int i = 0; i < N; i++) {
            quality[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int runningMax = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = quality[i] + runningMax;
            if(i > 0) runningMax = Math.max(runningMax, dp[i-1]);
        }
//        System.out.println(Arrays.toString(dp));

        int max = 0;
        for (int i = N-1; i >= 0; i--) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}