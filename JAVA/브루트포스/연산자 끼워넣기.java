import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long maxVal, minVal;
    static int[] four, arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        four = new int[4];
        arr = new int[n];
        String[] tmp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp1[i]);
        }
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<4;i++){
            four[i] = Integer.parseInt(tmp2[i]);
        }
        
        maxVal = Long.MIN_VALUE;
        minVal = Long.MAX_VALUE;
        
        recur(0, arr[0]);
        System.out.println(maxVal);
        System.out.println(minVal);
    }
    
    public static void recur(int idx, long num){
        if(idx == n-1){
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
            return;
        }
        if(four[0]>0){
            four[0]--;
            recur(idx+1, num+arr[idx+1]);
            four[0]++;
        }
        if(four[1]>0){
            four[1]--;
            recur(idx+1, num-arr[idx+1]);
            four[1]++;
        }
        if(four[2]>0){
            four[2]--;
            recur(idx+1, num*arr[idx+1]);
            four[2]++;
        }
        if(four[3]>0){
            four[3]--;
            recur(idx+1, (int)(num/arr[idx+1]));
            four[3]++;
        }
    }
}
