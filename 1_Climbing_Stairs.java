import java.util.*;

public class Climbing_Stairs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int[] dp = new int[stairs + 1];
        for(int i = 0 ; i <= stairs ; i++){
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        findAns(dp, stairs);
        System.out.print(dp[stairs]);
    }
    public static void findAns(int[] dp, int n){
        int prev = dp[1];
        int prev2 = dp[0];
        int i = 2;
        while(i <= n){
            dp[i] = prev + prev2;
            prev2 = prev;
            prev = dp[i];
            i++;
        }
    }
}
