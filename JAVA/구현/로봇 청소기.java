import java.util.*;
import java.io.*;

public class Main {
    static int n, m, cnt, x, y, d;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        n = Integer.parseInt(tmp1[0]);
        m = Integer.parseInt(tmp1[1]);
        map = new int[n][m];
        cnt = 0;
        
        String[] tmp2 = br.readLine().split(" ");
        x = Integer.parseInt(tmp2[0]);
        y = Integer.parseInt(tmp2[1]);
        d = Integer.parseInt(tmp2[2]);
        
        for(int i=0;i<n;i++){
            String[] tmp3 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(tmp3[j]);
            }
        }
        
        game();
        
        System.out.println(cnt);
    }
    
    public static void game(){
        while(true){
            boolean state = false;
            if(map[x][y] !=2){
                map[x][y] = 2;
                cnt++;   
            }
            int[] arr;
            
            if(d==0) arr = new int[] {3, 2, 1, 0};
            else if(d==1) arr = new int[] {0, 3, 2, 1};
            else if(d==2) arr = new int[] {1, 0, 3, 2};
            else arr = new int[] {2, 1, 0, 3};
            
            for(int i=0;i<4;i++){
                d = arr[i];
                int tx = x+dx[d];
                int ty = y+dy[d];
                if(map[tx][ty]!=1 && map[tx][ty]!=2){
                    x = tx;
                    y = ty;
                    state = true;
                    break;
                }   
            }
            
            if(!state){
                boolean state2 = false;
                for(int i=0;i<4;i++){
                    if(d==i){
                        int k = (i+2)%4;
                        if(map[x+dx[k]][y+dy[k]]==1){
                            state2 = true;
                            break;
                        }
                    }
                }
                if(state2){
                    break;
                }else{
                    x = x+dx[(d+2)%4];
                    y = y+dy[(d+2)%4];
                }
            }
        }
    }
}
