import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] input, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n+1];
        dp = new int[n+1];
        for(int i=1;i<=n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        recur();
    }
    public static void recur(){
        dp[1] = input[1];
        if(n>1){
            dp[2] = dp[1] + input[2];
        }
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2]+input[i], dp[i-3]+input[i-1]+input[i]);
        }
        System.out.println(dp[n]);
    }
}
