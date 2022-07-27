import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] map;
    static boolean[][] bMap1;
    static boolean[][] bMap2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        bMap1 = new boolean[n][n];
        bMap2 = new boolean[n][n];
        for(int i=0;i<n;i++){
            String tmp1 = br.readLine();
            for(int j=0;j<n;j++){
                map[i][j] = tmp1.charAt(j);
            }
        }
        
        int cnt1=0;
        int cnt2=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!bMap1[i][j]){
                    cnt1++;
                    bMap1[i][j] = true;
                    if(map[i][j]=='B'){
                        cnt2++;
                        bMap2[i][j] = true;
                    } 
                    dfs(map[i][j], i, j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!bMap2[i][j]){
                    cnt2++;
                    bMap2[i][j] = true;
                    dfs2(map[i][j], i, j);
                }
            }
        }
        
        System.out.println(cnt1+" "+cnt2);
    }
    
    public static void dfs(char last, int x, int y){        
        for(int i=0;i<4;i++){
            if(x+dx[i]<0||x+dx[i]>=n||y+dy[i]<0||y+dy[i]>=n) continue;
        
            if(!bMap1[x+dx[i]][y+dy[i]]&&last==map[x+dx[i]][y+dy[i]]){
                if(last=='B') bMap2[x+dx[i]][y+dy[i]] = true;
                bMap1[x+dx[i]][y+dy[i]] = true;
            }else continue;
            dfs(map[x+dx[i]][y+dy[i]], x+dx[i], y+dy[i]);
        }
    }
    
    public static void dfs2(char last, int x, int y){        
        for(int i=0;i<4;i++){
            if(x+dx[i]<0||x+dx[i]>=n||y+dy[i]<0||y+dy[i]>=n) continue;
        
            if(!bMap2[x+dx[i]][y+dy[i]]){
                if(last==map[x+dx[i]][y+dy[i]]||(last=='R'&&map[x+dx[i]][y+dy[i]]=='G')||(last=='G'&&map[x+dx[i]][y+dy[i]]=='R')) bMap2[x+dx[i]][y+dy[i]] = true;
                else continue;
            }else continue;
            dfs2(map[x][y], x+dx[i], y+dy[i]);
        }
    }
}
