import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        int n = Integer.parseInt(tmp1[0]);
        int k = Integer.parseInt(tmp1[1]);
        int[] arr = new int[n+1];
        int[] dp = new int[k+1];
        
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=arr[i];j<=k;j++){
                dp[j] = dp[j] + dp[j-arr[i]];
            }
        }
        
        System.out.println(dp[k]);
    }
}
