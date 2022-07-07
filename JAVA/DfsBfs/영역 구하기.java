import java.util.*;
import java.io.*;

public class Main {
    static int m, n, k, aCnt, iCnt;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        m = Integer.parseInt(tmp1[0]);
        n = Integer.parseInt(tmp1[1]);
        k = Integer.parseInt(tmp1[2]);
        map = new int[m][n];
        aCnt = 0;
        
        for(int i=0;i<k;i++){
            String[] tmp2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(tmp2[0]);
            int y1 = Integer.parseInt(tmp2[1]);
            int x2 = Integer.parseInt(tmp2[2]);
            int y2 = Integer.parseInt(tmp2[3]);
            
            for(int j=y1;j<y2;j++){
                for(int k=x1;k<x2;k++){
                    map[j][k] = 1;
                }
            }
        }
        
        int[] arr = new int[(int)((m*n)/2)];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                iCnt = 0;
                if(map[i][j]==0){
                    dfs(i, j);
                    arr[aCnt++] = iCnt;
                    iCnt = 0;
                }
            }
        }
        
        int[] arr2 = new int[aCnt];
        for(int i=0;i<aCnt;i++){
            arr2[i] = arr[i];
        }
        
        Arrays.sort(arr2);
        System.out.println(aCnt);
        for(int i=0;i<aCnt;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
            
    }
    
    public static void dfs(int x, int y){
        if(x>=m || x<0 || y>=n || y<0){
            return;
        }
        
        if(map[x][y] > 0){
            return;
        }
        map[x][y] = 1;
        iCnt++;
        
        for(int i=0;i<4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }
}
