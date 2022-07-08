import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] bus;
    static int[] table;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        bus = new int[n+1][n+1];
        table = new int[n+1];
        for(int i=1;i<=n;i++){
            table[i] = Integer.MAX_VALUE;
            for(int j=1;j<=n;j++){
                bus[i][j] = Integer.MAX_VALUE;
            }
        } 
        visited = new boolean[n+1];
        for(int i=0;i<m;i++){
            String[] tmp1 = br.readLine().split(" ");
            int a = Integer.parseInt(tmp1[0]);
            int b = Integer.parseInt(tmp1[1]);
            int c = Integer.parseInt(tmp1[2]);
            bus[a][b] = Math.min(bus[a][b], c);
        }
        
        String[] tmp2 = br.readLine().split(" ");
        int start = Integer.parseInt(tmp2[0]);
        int end = Integer.parseInt(tmp2[1]);
        table[start] = 0;
        
        while(start!=end){
            for(int i=1;i<=n;i++){
                if(bus[start][i]!=Integer.MAX_VALUE){
                    table[i] = Math.min(table[i], table[start]+bus[start][i]);
                }
            }
            visited[start] = true;
            int min = Integer.MAX_VALUE;
            int minNode = start;
            for(int i=1;i<=n;i++){
                if(!visited[i]&&min>table[i]){
                    min = table[i];
                    minNode = i;
                }
            }
            start = minNode;
        }
        
        System.out.println(table[end]);
    }
}
