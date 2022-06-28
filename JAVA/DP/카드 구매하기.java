import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] card, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        card = new int[n+1];
        dp = new int[n+1];
        String[] tmp1 = br.readLine().split(" ");
        
        for(int i=1;i<=n;i++){
            card[i] = Integer.parseInt(tmp1[i-1]);
        }
        
        dp[1] = card[1];
        for(int i=2;i<=n;i++){
            int max = card[i];
            for(int j=1;j<=(int)(i/2);j++){
                if(max<dp[j]+dp[i-j]){
                    max = dp[j]+dp[i-j];
                }
            }
            dp[i] = max;
        }
        
        System.out.println(dp[n]);
    }
}
