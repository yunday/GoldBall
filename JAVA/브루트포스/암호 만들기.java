import java.util.*;
import java.io.*;

public class Main {
    static int l, c;
    static char[] alpha, result;
    static char[] arr={'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        l = Integer.parseInt(tmp1[0]);
        c = Integer.parseInt(tmp1[1]);
        alpha = new char[c];
        result = new char[l];
        
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<c;i++){
            alpha[i] = tmp2[i].charAt(0);
        }
        
        Arrays.sort(alpha);
        
        dfs(0, -1);
    }
    
    public static void dfs(int idx, int last){
        if(idx==l){
            int mo = 0;
            int ja = 0;
            for(int i=0;i<l;i++){
                if(isMo(result[i])) mo++;
                else ja++;
            }
            if(mo<1||ja<2) return;
            for(int i=0;i<l;i++){
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }
        
        for(int i=last+1;i<c;i++){
            result[idx] = alpha[i];
            dfs(idx+1, i);
        }
    }
    
    public static boolean isMo(char a){
        for(int j=0;j<5;j++){
            if(a==arr[j]){
                return true;
            }
        }
        return false;
    }
}
