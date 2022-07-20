import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map, tmpMap, tmpMap2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        m = Integer.parseInt(tmp1[1]);
        map = new int[n][m];
        for(int i=0;i<n;i++){
            String[] tmp2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(tmp2[j]);
            }
        }
        
        int year = 0;
        while(true){
            year += 1;
            
            tmpMap2 = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    tmpMap2[i][j] = map[i][j];
                }
            }
            // 빙하녹히기
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(tmpMap2[i][j]!=0){
                        int cnt1 = 0;
                        for(int k=0;k<4;k++){
                            if(i+dx[k]<0||i+dx[k]>=n||j+dy[k]<0||j+dy[k]>=m)	continue;
                            if(tmpMap2[i+dx[k]][j+dy[k]]==0) cnt1++;
                        }
                        if(map[i][j]>=cnt1) map[i][j]-=cnt1;
                        else map[i][j] = 0;
                    } 
                }
            }
            
            // 몇 덩이인지 알아보기
            tmpMap = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    tmpMap[i][j] = map[i][j];
                }
            }
            int cnt = 0;
            boolean state = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(tmpMap[i][j]!=0){
                        dfs(i, j);
                        state = true;
                        cnt += 1;
                    } 
                }
            }
            if(cnt>1) break;
            if(!state){
                year = 0;
                break;
            }
        }
        System.out.println(year);
    }
    
    public static void dfs(int x, int y){
        if(x<0||x>=n||y<0||y>=m) return;
        if(tmpMap[x][y]==0) return;
        
        tmpMap[x][y] = 0;
        for(int i=0;i<4;i++){
            dfs(x+dx[i], y+dy[i]);
        }
    }
}
