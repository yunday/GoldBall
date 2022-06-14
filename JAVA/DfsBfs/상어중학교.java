/* 메모리며 시간이며 어느 하나 잘한 것이 없지만 힘들어서 여기서 그만둔다. 이런 문제는 코테에 나오면 버릴예정이기 때문이다 */
/* 그치만 만약에 다음에 다시 푼다면 배열을 다 새로 생성하는게 아니고 boolean 배열로 간단하게 만들것임 */

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static Integer[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        map = new Integer[n][n];
        int score = 0;
        for(int i=0;i<n;i++){
            String[] s2 = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }
        
        while(true){
            int sc = findBlock();
            if(sc == 0){
                System.out.println(score);
                break;
            }else{
                score += sc;
                gravity();
                clock();
                gravity();
                
            }
        }

    }
    
    public static int findBlock(){
        int maxVal = 0;
        int max0 = 0;
        int x=-1; int y=-1;
        Integer[][] tmpMap = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tmpMap[i][j]!=null && tmpMap[i][j]>0){
                    int[][] zero = new int[n*n][2];
                    int[] result = bfs(i, j, false, tmpMap, zero);
                    if(maxVal < result[0]){
                        maxVal = result[0];
                        max0 = result[1];
                        x = i;
                        y = j;
                    }else if(maxVal == result[0]){
                        if(max0 < result[1]){
                            max0 = result[1];
                            x = i;
                            y = j;
                        }else if(max0 == result[1]){
                            x = i;
                            y = j;
                        }
                    }
                    
                    for(int k=0;k<result[1];k++){
                        tmpMap[zero[k][0]][zero[k][1]] = 0;
                    }
                    
                }
            }
        }
        if(maxVal < 2){
            return 0;
        }
        Integer[][] tmpMap2 = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmpMap2[i][j] = map[i][j];
            }
        }
        bfs(x, y, true, tmpMap2, new int[n*n][2]);
        return (int)Math.pow(maxVal, 2);
        
    }
    
    public static int[] bfs(int x, int y, boolean b, Integer[][] tmpMap, int[][] zero){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {x, y});
        tmpMap[x][y] = -2;
        int cnt = 1;
        int cnt0 = 0;
        int tr = map[x][y];
        if(b){
            map[x][y] = null;
        }
        
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0;i<4;i++){
                if(p[0]+dx[i]>=0 && p[0]+dx[i]<n && p[1]+dy[i]>=0 && p[1]+dy[i]<n && tmpMap[p[0]+dx[i]][p[1]+dy[i]]!=null){
                    if(tmpMap[p[0]+dx[i]][p[1]+dy[i]]==0 || tmpMap[p[0]+dx[i]][p[1]+dy[i]]==tr){
                        if(b){
                            map[p[0]+dx[i]][p[1]+dy[i]] = null;
                        }
                        if(tmpMap[p[0]+dx[i]][p[1]+dy[i]] == 0){
                            zero[cnt0][0] = p[0]+dx[i];
                            zero[cnt0][1] = p[1]+dy[i];
                            cnt0 += 1;
                        }
                        tmpMap[p[0]+dx[i]][p[1]+dy[i]] = -2;
                        cnt += 1;
                        q.add(new int[] {p[0]+dx[i], p[1]+dy[i]});
                    }
                }
            }
        }
        int[] result = {cnt, cnt0};
        return result;
    }
    
    public static void gravity(){
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(map[j][i] != null && map[j][i] != -1){
                    for(int k=j+1;k<n;k++){
                        if(k==j+1 && map[k][i]!=null){
                            break;
                        }
                        if(k==n-1 && map[k][i] == null){
                            map[k][i] = map[j][i];
                            map[j][i] = null;
                        }else if(map[k][i] != null){
                            map[k-1][i] = map[j][i];
                            map[j][i] = null;
                            break;
                        }
                    }
                }
            }
        }
    
    }
    
    public static void clock(){
        Integer[][] tmpMap = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmpMap[i][j] = map[i][j];
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                map[n-i-1][j] = tmpMap[j][i];
            }
        }

    }
}
