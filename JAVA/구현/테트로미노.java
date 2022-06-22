import java.util.*;
import java.io.*;

public class Main {
    static int n, m, result;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] t;
    static boolean[][] bolmap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmps = br.readLine().split(" ");
        n = Integer.parseInt(tmps[0]);
        m = Integer.parseInt(tmps[1]);
        map = new int[n][m];
        for(int i=0;i<n;i++){
            String[] tmps2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(tmps2[j]);
            }
        }
        bolmap = new boolean[n][m];
        t = new int[4][2];
        result = 0;
        
        findMax();
        System.out.println(result);
    }
    
    public static void findMax(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tetro(i, j, 0);
                bolmap[i][j] = false;
            }
        }
    }
    
    public static int tetro(int x, int y, int idx){
        if(x>=n || x<0 || y>=m || y<0 || bolmap[x][y]){
            return 1;
        }
        
        bolmap[x][y] = true;
        t[idx][0] = x;
        t[idx][1] = y;
        
        if(idx == 3){
            /* 테트로 배열 값 모두 더해서 최대값 갱신 */
            int sum = 0;
            for(int i=0;i<4;i++){
                sum += map[t[i][0]][t[i][1]];
            }
            if(sum > result) result = sum;
            return 0;
        }
        /* 지금까지 갔던 모든 좌표 돌면서 재귀에 추가 */
        for(int i=0;i<idx+1;i++){
            for(int j=0;j<4;j++){
                if(tetro(t[i][0]+dx[j], t[i][1]+dy[j], idx+1) != 1){
                    bolmap[t[i][0]+dx[j]][t[i][1]+dy[j]] = false;
                }
            }
        }
        return 0;
    }
}
