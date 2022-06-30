import java.util.*;
import java.io.*;

public class Main {
    static int n, min, max, result;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] tmpMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n= Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        result = 1;
        
        boolean[] b = new boolean[101];
        map = new int[n][n];
        
        for(int i=0;i<n;i++){
            String[] tmp1 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                int a = Integer.parseInt(tmp1[j]);
                map[i][j] = a;
                b[a] = true;
                min = Math.min(a, min);
                max = Math.max(a, max);
            }
        }
    
        for(int i=min;i<=max;i++){
            if(b[i]){
                int cnt = 0;
                tmpMap = new boolean[n][n];
                
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(map[j][k]<=i){
                            map[j][k] = -1;
                            tmpMap[j][k] = true;
                        } 
                    }
                }
                
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        if(!tmpMap[j][k]){
                            cnt++;
                            dfs(j, k);
                        }
                    }
                }
                result = Math.max(result, cnt);
            }
        }
        
        System.out.println(result);
        
    }
    
    public static void dfs(int x, int y){
        if(x>n-1 || x<0 || y>n-1 || y<0) return;
        if(tmpMap[x][y]) return;
        
        tmpMap[x][y] = true;
        for(int i=0;i<4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }
}
