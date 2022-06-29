// 포문 두개쓰는거에 겁내지 마라잉

import java.util.*;
import java.io.*;

public class Main {
    static int n, max;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        String[] tmp1 = br.readLine().split(" ");
        arr = new int[n];
        dp = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp1[i]);
        }
        max = arr[0];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            dp[i] = arr[i];
            for(int j=i;j>0;j--){
                if(arr[i]>arr[j-1]){
                    dp[i] = Math.max(arr[i]+dp[j-1], dp[i]);
                }
            }
        }
        for(int i=1;i<n;i++){
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
