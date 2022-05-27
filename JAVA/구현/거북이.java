import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int maxX = 0, maxY=0, minX=0, minY=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            System.out.println(turtle(str));
            maxX=0;
            maxY=0;
            minX=0; 
            minY=0;
        }
    }
    
    public static int turtle(String str){
        int state = 0; // 0:북 1:동 2:남 3:서
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int nx = 0, ny = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='F'){
                nx +=dx[state];
                ny +=dy[state];
                maxMin(nx, ny);
            }else if(str.charAt(i)=='B'){
                nx += dx[(state+2)%4];
                ny += dy[(state+2)%4];
                maxMin(nx, ny);
            }else if(str.charAt(i)=='R'){
                state = (state + 1)%4;
            }else{
                if(state == 0){
                    state+=3;
                }else{
                    state -=1;   
                }
            }
        }
        return (maxX-minX)*(maxY-minY);
    }
    public static void maxMin(int nx, int ny){
        maxX = Math.max(maxX, nx);
        maxY = Math.max(maxY, ny);
        minX = Math.min(minX, nx);
        minY = Math.min(minY, ny);
    }
}
