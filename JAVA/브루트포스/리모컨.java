import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static boolean[] broken;
    public static void main(String[] args)throws NumberFormatException, Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String numS = br.readLine();
        n = Integer.parseInt(numS);
        m = Integer.parseInt(br.readLine());
        
        broken = new boolean[10];
        int result = Math.abs(n-100);
        if(m!=0){
            String[] tmps1 = br.readLine().split(" ");   
            for(int i=0;i<m;i++){
                broken[Integer.parseInt(tmps1[i])] = true;
            }
        }
        
        /* 1. 조합할 수 있는 수 중에서 n과 가장 근접한 수 만들기 */
        /* 위같은 ㅄ같은 짓은 하면 안됨 */
        /* 모든 수를 도는 브루트 포스로 풀어보자이 */
        
        for(int i=0;i<=999999;i++){
            String str = String.valueOf(i);
            
            boolean isBreak = false;
            for(int j=0;j<str.length();j++){
                String tmps2 = "";
                tmps2 += str.charAt(j);
                if(broken[Integer.parseInt(tmps2)]){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(n - i) + str.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
