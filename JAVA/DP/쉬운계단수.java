/* 제발 제출할 때 디버깅한거 지우셈.. */
/* 나머지를 구하라고 했을때는 모든 계산 결과에서 다 고려해주어야함 */

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long result;
    static long[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new long[10][n+1];
        result = 0;
        
        dp();
        for(int i=1;i<=9;i++){
            result = (result + arr[i][n])%1000000000;
        }
        
        System.out.println(result%1000000000);
    }
    
    public static void dp(){
        for(int i=1;i<=9;i++){
            arr[i][1] = 1;
        }
        arr[1][0] = 1;
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=9;j++){
                if(j==1){
                    arr[j][i] = (arr[j][i-2]+arr[j+1][i-1])%1000000000;
                }else if(j==9){
                    arr[j][i] = arr[j-1][i-1];
                }else{
                    arr[j][i] = (arr[j-1][i-1]+arr[j+1][i-1])%1000000000;
                }
            }
        }
    }
}
