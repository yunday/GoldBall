import java.util.*;
import java.io.*;

public class Main {
    static int n, m, minVal;
    static int[][] map, scMap, chicken;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        m = Integer.parseInt(tmp1[1]);
        minVal = Integer.MAX_VALUE;
        map = new int[n+1][n+1];
        scMap = new int[n+1][n+1];
        chicken = new int[m][2];
        int chiCnt = 0;
        int chiCnt2 = 0;
        
        for(int i=1;i<=n;i++){
            String[] tmp2 = br.readLine().split(" ");
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(tmp2[j-1]);
                if(map[i][j]==2){
                    chiCnt++;
                    scMap[i][j] = 0;
                } 
                else scMap[i][j] = map[i][j];
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j] == 2){
                    chiCnt2++;
                    if(chiCnt-chiCnt2>=m-1){
                        scMap[i][j] = 2;
                        chicken[0][0] = i;
                        chicken[0][1] = j;
                        dfs(1, i, j);
                        scMap[i][j] = 0;
                    }else break;
                }
            }
        }
        
        System.out.println(minVal);
    }
    
    public static void dfs(int idx, int x, int y){
        if(idx==m){
            minVal = Math.min(road(), minVal);
            return;
        }
        for(int i=x;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==x && j<=y) continue;
                if(map[i][j] == 2){
                    scMap[i][j] = 2;
                    chicken[idx][0] = i;
                    chicken[idx][1] = j;
                    dfs(idx+1, i, j);
                    scMap[i][j] = 0;
                }
            }
        }
    }
    
    public static int road(){
        int result = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int min = Integer.MAX_VALUE;
                if(scMap[i][j]==1){
                    for(int k=0;k<m;k++){
                        min = Math.min(min, Math.abs(i-chicken[k][0])+Math.abs(j-chicken[k][1]));
                    }
                    result += min;
                }
            }
        }
        return result;
    }
}
