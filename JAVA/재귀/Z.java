import java.util.*;
import java.io.*;

public class Main {
    static int n,r,c, cnt, val;
    static boolean b;
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        r = Integer.parseInt(tmp[1]);
        c = Integer.parseInt(tmp[2]);
        cnt = 0;
        b = false;
        val = (int)Math.pow(2, n);
        
        recur(val, r, c);
        System.out.println(cnt);
    }
    
    public static void recur(int k, int r, int c){
        if(k == 1) return;
        if(r<k/2 && c<k/2){
            recur(k/2, r, c);
        }else if(r<k/2 && c>=k/2){
            cnt += (int)Math.pow(k/2, 2);
            recur(k/2, r, c-k/2);
        }else if(r>=k/2 && c<k/2){
            cnt += (int)(Math.pow(k/2, 2)*2);
            recur(k/2, r-k/2, c);
        }else{
            cnt += (int)(Math.pow(k/2, 2)*3);
            recur(k/2, r-k/2, c-k/2);
        }
    }
}
