import java.util.*;
import java.io.*;

public class Main {
    static int[][] top;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        top = new int[5][8];
        for(int i=1;i<=4;i++){
            String[] tmp1 = br.readLine().split("");
            for(int j=0;j<8;j++){
                top[i][j] = Integer.parseInt(tmp1[j]);
            }
        }
        
        k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++){
            String[] tmp2 = br.readLine().split(" ");
            int nowT = Integer.parseInt(tmp2[0]);
            int dirC = Integer.parseInt(tmp2[1]);
            bfs(nowT, dirC);
        }
        
        int sum = 0;
        for(int i=1;i<=4;i++){
            if(top[i][0]==1) sum += (int)Math.pow(2, i-1);
        }
        System.out.println(sum);
        
    }
    
    public static void turn(int num, int dir){
        if(dir==1){
            int tmp = top[num][7];
            for(int j=7;j>0;j--){
                top[num][j] = top[num][j-1];
            }
            top[num][0] = tmp;
        }else{
            int tmp = top[num][0];
            for(int j=0;j<7;j++){
                top[num][j] = top[num][j+1];
            }
            top[num][7] = tmp;
        }
    }
    
    public static void bfs(int num, int dir){
        
        boolean[] same = new boolean[3];
        
        for(int i=1;i<4;i++){
            if(top[i][2] == top[i+1][6]){
                same[i-1] = true;
            }
        }
        turn(num, dir);
        
        int firstDir = dir;
        //right
        for(int i=num;i<4;i++){
            if(!same[i-1]){
                dir = -dir;
                turn(i+1, dir);
            }else{
                break;
            }
        }
        
        //left
        dir = firstDir;
        for(int i=num;i>1;i--){
            if(!same[i-2]){
                dir = -dir;
                turn(i-1, dir);
            }else{
                break;
            }
        }
    }
}
