import java.io.*;
import java.util.*;

public class Main{
    
    static int[] dirX = {-1, 0, 1, 0, 0, 0};
    static int[] dirY = {0, 1, 0, -1, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, -1, 1};
    
    static class coor{
        int x, y, z;
        public coor(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int m, n, h;
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        h = Integer.parseInt(str[2]);

        int[][][] arr = new int[h][n][m];
        for(int k=0;k<h;k++){
            for(int i=0;i<n;i++){
                str = br.readLine().split(" ");
                for(int j=0;j<m;j++){
                    arr[k][i][j] = Integer.parseInt(str[j]);
                }
            }
        }

        
        System.out.println(bfs(arr, n, m, h));

    }
    public static int bfs(int[][][] arr, int n, int m, int h){
        Queue<coor> q = new LinkedList<coor>();
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[i][j][k] == 1){
                        q.add(new coor(i, j, k));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            coor p = q.poll();
            for(int i=0;i<6;i++){
                if(p.x+dirX[i]<0 || p.x+dirX[i]>n-1 || p.y+dirY[i]<0 || p.y+dirY[i]>m-1 || p.z+dirZ[i]<0 || p.z+dirZ[i]>h-1){
                    continue;
                }
                if(arr[p.z+dirZ[i]][p.x+dirX[i]][p.y+dirY[i]] != 0){
                    continue;
                }
                arr[p.z+dirZ[i]][p.x+dirX[i]][p.y+dirY[i]] = arr[p.z][p.x][p.y]+1;
                q.add(new coor(p.z+dirZ[i], p.x+dirX[i], p.y+dirY[i]));
            }
        }
        
        int max = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[i][j][k] == 0){
                        return -1;
                    }
                    max = arr[i][j][k] > max? arr[i][j][k] : max;
                }
            }
        }
        return max-1;
    }
}
