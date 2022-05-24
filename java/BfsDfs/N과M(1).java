import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static boolean[] arr;
    public static int[] arr2;
    // 출력도 StringBuilder로 해서 시간 단축하자
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new boolean[N];
        arr2 = new int[M];
        
        dfs(0);
        System.out.println(sb);
    }
    
    public static void dfs(int idx) throws Exception{
        if(idx == M){
            for(int j=0;j<M;j++){
                sb.append(arr2[j]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!arr[i]){
                arr2[idx] = i+1;
                arr[i] = true;
                dfs(idx+1);
                arr[i] = false;
            }
        }
    }
}
