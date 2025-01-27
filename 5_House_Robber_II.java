import java.util.*;

public class House_Robber_II {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = sc.nextInt();

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for(int i = 0 ; i < n - 1 ; i++) temp1[i] = nums[i];
        for(int i = 0 ; i < n - 1 ; i++) temp1[i] = nums[i + 1];

        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) dp[i] = -1;

        int ans1 = findAns(dp, temp1, temp1.length - 1);
        int ans2 = findAns(dp, temp2, temp2.length - 1);

        System.out.print(Math.max(ans1, ans2));
    }
    public static int findAns(int[] dp, int[] arr, int ind){
        if(ind == 0) return arr[ind];
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = arr[ind] + findAns(dp, arr, ind - 2);
        int notpick = findAns(dp, arr, ind - 1);
        return dp[ind] = Math.max(pick, notpick);
    }
}
