import java.util.*;
import java.io.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        k = Integer.parseInt(s[4]);
        map = new int[n][m];
        dice = new int[6]; /* 0밑-1뒤-2위-3앞-4왼-5오 순*/
        
        for(int i=0;i<n;i++){
            String[]s2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(s2[j]);
            }
        }
        
        String[] s3 = br.readLine().split(" ");
        for(int i=0;i<k;i++){
            int command = Integer.parseInt(s3[i]);
            switch(command){
                /* 1. 범위를 넘어가는지 여부 */
                case 1: if(y+1>=0 && y+1<m){
                    /* 동쪽 */
                    y += 1;
                    /* 2. 이동 칸이 0이면 주사위를 맵에 복사 / 0이 아니면 주사위 바닥면에 복사  */
                    changeDice(1);
                    if(map[x][y]==0){
                        map[x][y] = dice[0];
                    }else{
                        dice[0] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(dice[2]);
                }
                    break;
                case 2: if(y-1>=0 && y-1<m){
                    /* 서쪽 */
                    y -= 1;
                    changeDice(2);
                    if(map[x][y]==0){
                        map[x][y] = dice[0];
                    }else{
                        dice[0] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(dice[2]);
                }
                    break;
                case 3: if(x-1>=0 && x-1<n){
                    /* 북쪽 */
                    x -= 1;
                    changeDice(3);
                    if(map[x][y]==0){
                        map[x][y] = dice[0];
                    }else{
                        dice[0] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(dice[2]);
                }
                    break;
                case 4: if(x+1>=0 && x+1<n){
                    /* 남쪽 */
                    x += 1;
                    changeDice(4);
                    if(map[x][y]==0){
                        map[x][y] = dice[0];
                    }else{
                        dice[0] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(dice[2]);
                }
                    break;
            }
        }
    }
    
    public static void changeDice(int ver){
        int tmp;
        switch(ver){
            case 1: tmp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[4];
                dice[4] = tmp;
                break;
            case 2: tmp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[5];
                dice[5] = tmp;
                break;
            case 3: tmp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = tmp;
                break;
            case 4: tmp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = tmp;
                break;
        }
    }
}
