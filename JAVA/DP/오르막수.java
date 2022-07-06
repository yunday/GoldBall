import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int maxVal = 0;
        for(int i=0;i<n;i++){
            maxVal += (int)(9*Math.pow(10, i));
        }
        int[][] dp = new int[n+1][10];
        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        if(n==1) cnt = 10;
    	
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++){
                    dp[i][j] += dp[i-1][k]%10007;
                    dp[i][j] %= 10007;
                }
                if(i==n){
                    cnt += dp[i][j];
                    cnt %= 10007;
                }
            }
        }
        
        System.out.println(cnt%10007);
    }
}
