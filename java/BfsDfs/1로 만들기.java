import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        arr[0] = arr[1] = 0;
        dp(n);
    }
    public static void dp(int n){
        for(int i=2;i<n+1;i++){
            arr[i] = arr[i-1]+1;
            if(i%3 == 0){
                arr[i] = Math.min(arr[i], arr[i/3]+1);
            }
            if(i%2 == 0){
                arr[i] = Math.min(arr[i], arr[i/2]+1);
            }
        }
        System.out.println(arr[n]);
    }
}
