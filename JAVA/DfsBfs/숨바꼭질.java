package project;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        int n, k;
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        
        System.out.println(bfs(n, k));
        
    }
    public static int bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int[] maze = new int[100001];
        maze[n] = 1;
        q.add(n);
        int nowX;
        while(!q.isEmpty()){
            nowX = q.poll();
            if(nowX == k){
                return maze[nowX] - 1;
            }
            if(nowX-1>=0 && nowX-1<=100000 && maze[nowX-1] == 0){
                maze[nowX-1] = maze[nowX] + 1;
                q.add(nowX-1);
            }
            if(nowX+1>=0 && nowX+1<=100000 && maze[nowX+1] == 0){
                q.add(nowX+1);
                maze[nowX+1] = maze[nowX] + 1;   
            }
            if(nowX*2>=0 && nowX*2<=100000 && maze[nowX*2] == 0){
                q.add(nowX*2);
                maze[nowX*2] = maze[nowX] + 1;   
            }
        }
        return -1;
    }

}
