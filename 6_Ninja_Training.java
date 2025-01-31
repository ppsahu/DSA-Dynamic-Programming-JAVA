import java.util.*;
public class Ninja_Training {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[][] points = new int[x][3];
        for(int i = 0 ; i < x ; i++){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            points[i][2] = sc.nextInt();
        }
        int[][] dp = new int[x][4];
        for(int i = 0 ; i < x ; i++){
            for(int j = 0 ; j < 4 ; j++){
                dp[i][j] = -1;
            }
        }
        int ans = f(x - 1, 3, dp, points);
        System.out.print(ans);
    }
    public static int f(int day, int last, int[][] dp, int[][] points){
        if(dp[day][last] != -1) return dp[day][last];

        if(day == 0){
            int maxi = 0;
            for(int i = 0 ; i < 3 ; i++){
                if(i != last){
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(i != last){
                int activity = points[day][i] + f(day - 1, i, dp, points);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }
}
