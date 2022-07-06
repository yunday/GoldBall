import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        recur(n, 0, 0, false);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    public static void recur(int n, int x, int y, boolean mid){
        if(mid){
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        if(n==1){
            arr[x][y] = '*';
            return;
        }
        
        int size = n/3;
        int cnt = 0;
        for(int i=x;i<x+n;i+=size){
            for(int j=y;j<y+n;j+=size){
                cnt++;
                if(cnt==5) recur(size, i, j, true);
                else recur(size, i, j, false);
            }
        }
    }
}
