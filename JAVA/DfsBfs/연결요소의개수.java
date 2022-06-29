//이거 왜 이러냐 코드 같은데 시간 왤케 오래거림ㅁ;

import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static LinkedList<Integer>[] graph;
    static boolean[] g;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new boolean[n+1];
        graph = new LinkedList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new LinkedList<Integer>();
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int cnt = 0;
        
        for(int i=1;i<=n;i++){
            if(!g[i]){
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static void dfs(int idx){
        if(g[idx]){
            return;
        }
        g[idx] = true;
        for(int i=0;i<graph[idx].size();i++){
            dfs(graph[idx].get(i));
        }
    }
}
