import java.util.*;
import java.io.*;

public class Main {
    static int n, x, y, w, cnt, result;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        w = 2;
        cnt = 0;
        result = 0;
        for(int i=0;i<n;i++){
            String[] tmp1 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(tmp1[j]);
                if(Integer.parseInt(tmp1[j])==9){
                    x = i;
                    y = j;
                }
            }
        }
        while(true){
            int minVal=500;
            int fx = x;
        	int fy = y;
            
            int[][] tmpMap = bfs();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]<w && map[i][j]>0){
                        if(minVal>tmpMap[i][j]-1){
                            fx = i;
                            fy = j;
                            minVal = tmpMap[i][j]-1;
                        }
                    }
                }
            }
            
            if(minVal==500){
                break;
            }
            map[x][y] = 0;
            map[fx][fy] = 9;
            x = fx;
            y = fy;
            cnt++;
            result += minVal;
            
            if(cnt == w){
                cnt = 0;
                w++;
            }
        }
        
        System.out.println(result);
    }
    
    public static int[][] bfs(){
        Queue<int[]> q = new LinkedList<>();
        
        int[][] map2 = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]<=w) map2[i][j] = 0;
                else if(map[i][j] == 9) map2[i][j] = 0;
                else map2[i][j] = 1;
            }
        }
        
        q.add(new int[] {x, y});
        map2[x][y] = 1;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            for(int i=0;i<4;i++){
                int newX = tmp[0]+dx[i];
                int newY = tmp[1]+dy[i];
                if(newX>n-1||newX<0||newY>n-1||newY<0){
                    continue;
                }
                if(map2[newX][newY]==0){
                    q.add(new int[] {newX, newY});
                    map2[newX][newY] = map2[tmp[0]][tmp[1]]+1;
                }
            }
        }
        
        return map2;
    }
}
