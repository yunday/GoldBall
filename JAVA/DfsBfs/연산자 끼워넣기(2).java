import java.util.*;
import java.io.*;

public class Main {
    public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n;
    public static int A[], F[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(a[i]);
        }
        String[] f = br.readLine().split(" ");
        F = new int[4];
        for(int i=0;i<4;i++){
            F[i] = Integer.parseInt(f[i]);
        }
        
        dfs(1, A[0]);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int idx, int sum){
        if(idx == n){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for(int i=0;i<4;i++){
            if(F[i] == 0){
                continue;
            }
            F[i]--;
            if(i == 0){
                dfs(idx+1, sum + A[idx]);
            }
            else if(i == 1){
                dfs(idx+1, sum-A[idx]);
            }
            else if(i == 2){
                dfs(idx+1, sum*A[idx]);
            }
            else if(i==3) {
                dfs(idx+1, sum/A[idx]);
            }
            F[i]++;
        }
    }
}
