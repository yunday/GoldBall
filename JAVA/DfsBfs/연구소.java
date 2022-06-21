/* 어쩔 수 없는 브루트포스는 확실히 하세요잉 */

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, maxVal;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        map = new int[n][m];
        for(int i=0;i<n;i++){
            String[] s2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }
        maxVal = Integer.MIN_VALUE;
        /* 1. 기준 점을 구한다 */
        /* 2. 나머지 2개 점도 순차적으로 정한다 --> dfs로 구해야함(backtracking) */ 
        /* 3. 세 점이 정해졌으면 BFS로 2를 확산시킨다 */
        /* 4. 남은 0 개수를 찾아서 max값과 비교한다 */
        /* 5. max값 출력 */
        DFS(0);
        System.out.println(maxVal);
    }
    
    public static void DFS(int d){
        if(d == 3){
            BFS();
            return;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    DFS(d+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void BFS(){
        int[][] tmpMap = new int[n][m];
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tmpMap[i][j] = map[i][j];
                if(tmpMap[i][j] == 2){
                    q.add(new int[] {i, j});
                }
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int[] xy = q.poll();
            int x, y;
            x=xy[0];
            y=xy[1];
            for(int i=0;i<4;i++){
                if(x+dx[i]<0 || x+dx[i]>=n || y+dy[i]<0 || y+dy[i]>=m){
                    continue;
                }
                if(tmpMap[x+dx[i]][y+dy[i]]==0){
                    q.add(new int[] {x+dx[i], y+dy[i]});
                    tmpMap[x+dx[i]][y+dy[i]] = 2;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tmpMap[i][j] == 0){
                    cnt += 1;
                }
            }
        }
        if(maxVal < cnt){
            maxVal = cnt;
        }
    }
}
