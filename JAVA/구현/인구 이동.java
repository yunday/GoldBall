import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r, result, cnt, population;
    static int[][] map, tmpMap;
    static boolean[][] bMap;
    static int[][] bMap2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        l = Integer.parseInt(tmp1[1]);
        r = Integer.parseInt(tmp1[2]);
        result = 0;
        map = new int[n][n];
        
    	for(int i=0;i<n;i++){
            String[] tmp2 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(tmp2[j]);
            }
        }
        while(true){
            int state = 0;
            bMap = new boolean[n][n];
            bMap2 = new int[n][n];
            tmpMap = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    tmpMap[i][j] = map[i][j];
                }
            }
            int count=1;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!bMap[i][j]){
                        cnt = 0;
                        population = 0;
                        dfs(i, j, count);
                        
                        if(cnt>1) count++;
                        else bMap2[i][j] = 0;
                    } 
                }
            }
            
            if(count==1) break;
            // 인구 값 바꾸기
            int[] arr = new int[count];
            int[] popu = new int[count];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(bMap2[i][j]!=0){
                        arr[bMap2[i][j]] += 1;
                        popu[bMap2[i][j]] += map[i][j];
                    }
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(bMap2[i][j]!=0){
                        map[i][j] = (int)(popu[bMap2[i][j]]/arr[bMap2[i][j]]);
                    }
                }
            }
            result += 1;
        }
        System.out.println(result);
    }
    
    public static void dfs(int x, int y, int count){
        bMap[x][y] = true;
        bMap2[x][y] = count;
        cnt++;
        for(int i=0;i<4;i++){
            if(x+dx[i]<0||x+dx[i]>=n||y+dy[i]<0||y+dy[i]>=n) continue;
            int value = Math.abs(tmpMap[x+dx[i]][y+dy[i]]-tmpMap[x][y]);
            if(!bMap[x+dx[i]][y+dy[i]] && value>=l && value<=r){
                dfs(x+dx[i], y+dy[i], count);
            }
        }
    }
}
