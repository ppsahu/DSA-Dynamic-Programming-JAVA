import java.util.*;

public class Frog_Jump {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] heights = new int[x];
        for(int i = 0 ; i < x ; i++) heights[i] = sc.nextInt();
        int[] dp = new int[x];
        dp[0] = 0;
        
        for(int i = 1 ; i < x ; i++){
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(fs, ss);
        }
        System.out.print(dp[x - 1]);
    }
}
