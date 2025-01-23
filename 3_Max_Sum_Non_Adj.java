import java.util.*;
public class Max_Sum_Non_Adj {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) dp[i] = -1;
        int ans = findAns(dp, arr, n - 1);
        System.out.print(dp[n - 1]);
    }
    public static int findAns(int[] dp, int[] arr, int ind){
        if(ind == 0) return arr[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = arr[ind] + findAns(dp, arr, ind - 2);
        int notpick = 0 + findAns(dp, arr, ind - 1);
        return dp[ind] = Math.max(pick, notpick);
    }
}
