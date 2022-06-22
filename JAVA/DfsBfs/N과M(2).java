import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[] arr = new int[m+1];
        nCm(1, arr);
    }
    
    public static void nCm(int idx, int[] arr){
        if(idx>m){
            for(int i=1;i<=m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=arr[idx-1]+1;i<=n;i++){
            arr[idx] = i;
            nCm(idx+1, arr);
        }
    }
}
