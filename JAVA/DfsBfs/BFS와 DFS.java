import java.util.*;
import java.io.*;

public class Main {
    static int n, m, v;
    static List<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);
        
        arr = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            String[] st = br.readLine().split(" ");
            arr[Integer.parseInt(st[0])].add(Integer.parseInt(st[1]));
            arr[Integer.parseInt(st[1])].add(Integer.parseInt(st[0]));
        }
        for(int i=1;i<=n;i++){
            Collections.sort(arr[i]);   
        }
        visited = new boolean[n+1];
        DFS(v);
        System.out.println();
        BFS();
        System.out.println();
    }
    public static void DFS(int k){
        visited[k] = true;
        System.out.print(k+" ");
        
        for(int i=0;i<arr[k].size();i++){
            int ag = arr[k].get(i);
            if(!visited[ag]){
                DFS(ag);
            }
        }
    }
    public static void BFS(){
        boolean[] map = new boolean[n+1];
        Queue<Integer> q = new LinkedList();
        q.add(v);
        map[v] = true;
        System.out.print(v+" ");
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<arr[node].size();i++){
                int ag = arr[node].get(i);
                if(!map[ag] && !q.contains(ag)){
                    q.add(ag);
                    System.out.print(ag+" ");
                    map[ag] = true;
                }
            }
        }
    }
}
