import java.util.*;
import java.io.*;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        prime = new boolean[10000];
        isPrime();
        /* 1. 10000까지의 소수 구함 */
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=n/2;j>1;j--){
                if(prime[j] && prime[n-j]){
                    System.out.println(j+" "+(n-j));
                    break;
                }
            }
        }
    }
    
    public static void isPrime(){
        for(int i=2;i<10000;i++){
            boolean state = false;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    state = true;
                    break;
                }
            }
            if(!state){
                prime[i] = true;
            }
        }
    }
}
