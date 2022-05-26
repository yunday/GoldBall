import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] rgb, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rgb = new int[n+1][3];
        dp = new int[n+1][3];
        for(int i=1;i<=n;i++){
            String[] a = br.readLine().split(" ");
            rgb[i][0] = Integer.parseInt(a[0]);
            rgb[i][1] = Integer.parseInt(a[1]);
            rgb[i][2] = Integer.parseInt(a[2]);   
        }
        recur(n);
    }
    public static void recur(int n){
        for(int i=0;i<3;i++){
            dp[1][i] = rgb[1][i];
        }
        for(int i=2;i<=n;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+rgb[i][2];
        }
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
