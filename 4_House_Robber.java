import java.util.*;
public class House_Robber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) dp[i] = -1;
        int ans = findAns(dp, nums, n - 1);
        System.out.print(ans);
    }
    public static int findAns(int[] dp, int[] nums, int ind){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + findAns(dp, nums, ind - 2);
        int notpick = findAns(dp, nums, ind - 1);
        return dp[ind] = Math.max(pick, notpick);
    }
}
