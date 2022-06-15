import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            for(int j=0;j<2;j++){
                String[] s = br.readLine().split(" ");
                for(int k=1;k<=n;k++){
                    arr[j][k] = Integer.parseInt(s[k-1]);
                }
            }
            
            int[][] dp = new int[2][n+1];
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int j=2;j<=n;j++){
                for(int k=0;k<2;k++){
                    dp[k][j] = arr[k][j]+Math.max(dp[(k+1)%2][j-1], dp[(k+1)%2][j-2]);
                }
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
