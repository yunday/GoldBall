import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        
        for(int i=0;i<2*n+1;i++){
            if(i%2 == 0){
                sb.append("I");   
            }else{
                sb.append("O");
            }
        }
        for(int i=0;i<m-(n*2+1);i++){
            if(s.substring(i, i+n*2+1).equals(sb.toString())){
                cnt += 1;
            }
        }
        
        System.out.println(cnt);
    }
}

/* 안타깝게도 반점짜리 풀이 */
