import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr, input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        input = new int[n+1];
        for(int i=1;i<=n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        recur();
    }
    public static void recur(){
        arr[1] = input[1];
        if(n>1){
            arr[2] = input[1] + input[2];
        }
        for(int i=3;i<=n;i++){
            arr[i] = Math.max(arr[i-1], Math.max(arr[i-2]+input[i], arr[i-3]+input[i-1]+input[i]));
        }
        System.out.println(arr[n]);
    }
}
