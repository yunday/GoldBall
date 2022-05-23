import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int M, N, K;
    static int[][] map;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int count = 0;
            String[] a = br.readLine().split(" ");
            M = Integer.parseInt(a[0]);
            N = Integer.parseInt(a[1]);
            K = Integer.parseInt(a[2]);
            map = new int[N][M];
            for(int j=0;j<K;j++){
                String[] b = br.readLine().split(" ");
                map[Integer.parseInt(b[1])][Integer.parseInt(b[0])] = 1;
            }
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(map[j][k] == 1){
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    
    public static void dfs(int x, int y){
        map[x][y] = 0;
        for(int i=0;i<4;i++){
            if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<M){
                if(map[x+dx[i]][y+dy[i]] == 1){
                     dfs(x+dx[i], y+dy[i]);
                }
            }
        }
    }
}
