import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[][] bag, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        k = Integer.parseInt(tmp1[1]);
        bag = new int[n+1][2];
        
        for(int i=1;i<=n;i++){
            String[] tmp2 = br.readLine().split(" ");
            bag[i][0] = Integer.parseInt(tmp2[0]);
            bag[i][1] = Integer.parseInt(tmp2[1]);
        }
        
        dp = new int[n+1][k+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(bag[i][0]>j){
                    // 이전 애들 중 최대값
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bag[i][0]]+bag[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
