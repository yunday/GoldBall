import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int to;
    int weight;
    
    Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static int v, e, k;
    static int[][] graph;
    static int[] dp;
    static List<Node>[] list;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        v = Integer.parseInt(tmp1[0]);
        e = Integer.parseInt(tmp1[1]);
        graph = new int[e][3];
        k = Integer.parseInt(br.readLine());
        for(int i=0;i<e;i++){
            String[] tmp2 = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                graph[i][j] = Integer.parseInt(tmp2[j]);
            }
        }
        
        solution();
        
    }
    
    public static void solution(){
        check = new boolean[v+1];
        dp = new int[v+1];
        list = new ArrayList[v+1];
        
        for(int i=1;i<v+1;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<graph.length;i++){
            int a = graph[i][0];
            int b = graph[i][1];
            int c = graph[i][2];
            
            list[a].add(new Node(b, c));
        }
        dijkstra(k);
        
        for(int i=1;i<dp.length;i++){
            if(dp[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dp[i]);
        } 
    }
    
    public static void dijkstra(int start){
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        q.add(new Node(start, 0));
        
        dp[start] = 0;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int to = node.to;
            
            if(check[to]) continue;
            else check[to] = true;
            
            for(Node nxt : list[to]){
                if(dp[nxt.to]>=dp[to]+nxt.weight){
                    dp[nxt.to] = dp[to]+nxt.weight;
                    q.add(new Node(nxt.to, dp[nxt.to]));
                }
            }
        }
    }
}
