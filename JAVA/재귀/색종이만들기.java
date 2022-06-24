import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] paper;
    static int white;
    static int blue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0;i<N;i++){
            String[] tmp1 = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(tmp1[j]);
            }
        }
        white = 0;
        blue = 0;
        
        recur(0, 0, N-1, N-1);
        System.out.println(white);
        System.out.println(blue);
    }
    
    public static boolean isAll(int x1, int y1, int x2, int y2){
        int isWhat = paper[x1][y1];
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(paper[i][j] != isWhat) return false;
            }
        }
        return true;
    }
    
    public static void recur(int x1, int y1, int x2, int y2){
        /* 재귀로 4등분하기 */        
        if(isAll(x1, y1, x2, y2)){
            if(paper[x1][y1] == 1){
                blue += 1;
                return;
            }
            else{
                white += 1;
                return;
            }
        }
        recur(x1, y1, (int)(x2+x1)/2, (int)(y2+y1)/2);
        recur(x1, (int)(y2+y1)/2+1, (int)(x1+x2)/2, y2);
        recur((int)(x1+x2)/2+1, y1, x2, (int)(y1+y2)/2);
        recur((int)(x1+x2)/2+1, (int)(y1+y2)/2+1, x2, y2);
    }
}
