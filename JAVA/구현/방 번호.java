import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int count = 1;
        
        for(int i=0;i<n.length();i++){
            char num = n.charAt(i);
            String s = "";
            s+= num;
            int a = Integer.parseInt(s);
            if(arr[a]==0){
                if(a==9){
                    if(arr[6]>0){
                        arr[6]--;
                        continue;
                    } 
                }else if(a==6){
                    if(arr[9]>0){
                        arr[9]--; 
                        continue;
                    } 
                }
                for(int j=0;j<10;j++){
                    arr[j]++;
                }
                arr[a]--;
                count++;
            }
            else{
                arr[a] -= 1;
            }
        }
        System.out.println(count);
    }
}
