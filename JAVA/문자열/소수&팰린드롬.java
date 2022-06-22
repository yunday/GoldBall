import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for(int i=n;i<=Integer.MAX_VALUE;i++){
            String k = String.valueOf(i);
            Character[] k2 = new Character[k.length()];
            String newVal = "";
            for(int j=0;j<k.length();j++){
                k2[j] = k.charAt(k.length()-j-1);
                newVal += Character.toString(k2[j]);
            }
            if(k.equals(newVal)){
                int cnt = 0;
                if(isPrime(i)){
                    System.out.println(i);
                    break;
                }
            }
        }
        
    }
    
    public static boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        if(num==1) return false;
        return true;
        
    }
}
