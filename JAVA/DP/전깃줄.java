/* https://chanhuiseok.github.io/posts/algo-49/ */
/* LIS 로 푼 문제 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] wire = new int[n][2];
        int[] dp = new int[n];
        for(int i=0;i<wire.length;i++){
            String[] s = br.readLine().split(" ");
            wire[i][0] = Integer.parseInt(s[0]);
            wire[i][1] = Integer.parseInt(s[1]);
        }
        
        Arrays.sort(wire, Comparator.comparingInt(o1->o1[0]));
        
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<n;j++){
                if(wire[j][1] < wire[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(n-max);
        
    }
}
