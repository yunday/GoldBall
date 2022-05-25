import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] L = new int[n];
        dir[] N = new dir[n];
        dir[] M = new dir[n];
        for(int i=0;i<n;i++){
            L[i] = Integer.parseInt(br.readLine());
            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");
            N[i] = new dir(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
            M[i] = new dir(Integer.parseInt(b[0]), Integer.parseInt(b[1]));
        }
        
        for(int i=0;i<n;i++){
             System.out.println(bfs(L[i], N[i], M[i]));   
        }
    }
    
    public static int bfs(int l, dir n, dir m){
        int[][] maze = new int[l][l];
        int[] d_x = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] d_y = {1, 2, 2, 1, -1, -2, -2, -1};
            
        Queue<dir> q = new LinkedList<dir>();
        q.add(n);
        while(!q.isEmpty()){
            dir d = q.poll();
            if(d.x == m.x && d.y == m.y){
                return maze[d.x][d.y];
            }
            for(int i=0;i<8;i++){
                if(d.x+d_x[i]<0 || d.x+d_x[i]>l-1 || d.y+d_y[i]<0 || d.y+d_y[i]>l-1){
                    continue;
                }
                if(maze[d.x+d_x[i]][d.y+d_y[i]] != 0){
                    continue;
                }
                q.add(new dir(d.x+d_x[i], d.y+d_y[i]));
                maze[d.x+d_x[i]][d.y+d_y[i]] = maze[d.x][d.y] + 1;
            }
        }
        return -1;
    }
    
    public static class dir{
        int x, y;
        public dir(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
