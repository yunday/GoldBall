import java.util.*;
import java.io.*;

public class Main {
    static int result, n,m;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        m = Integer.parseInt(tmp1[1]);
        arr = new int[n];
        result = 0;
        
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        
        /* 브루트포스로 풀어도 되나? ㅋㅋ -> 네 */
        for(int i=1;i<=n;i++){
            recur(i, 0, 0, 0);
        }
        
        System.out.println(result);
    }
    
    public static void recur(int k, int idx, int num, int now){
        if(idx == k){
            if(num == m){
                result+=1;
            } 
            return;
        }
        
        for(int i=now;i<n;i++){
            recur(k, idx+1, num+arr[i], i+1);
        }
    }
}
