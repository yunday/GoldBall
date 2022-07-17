import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        map = new int[n][m];
        bfs(0, 0, maps);
        if(map[n-1][m-1]==0) answer = -1;
        else answer = map[n-1][m-1];
        
        return answer;
    }
    
    public static void bfs(int xt, int yt, int[][] maps){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {xt, yt});
        map[xt][yt] = 1;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            
            for(int i=0;i<4;i++){
                if(x+dx[i]<0||x+dx[i]>=n||y+dy[i]<0||y+dy[i]>=m){
                    continue;
                }
                if(maps[x+dx[i]][y+dy[i]]==1){
                    if(map[x+dx[i]][y+dy[i]]==0 || map[x+dx[i]][y+dy[i]]>map[x][y]+1){
                        map[x+dx[i]][y+dy[i]] = map[x][y]+1;
                        q.add(new int[] {x+dx[i], y+dy[i]});
                    }
                }
            }
        }
    }
}
