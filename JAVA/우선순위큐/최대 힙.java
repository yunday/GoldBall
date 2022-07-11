import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(q.isEmpty()) sb.append(0+"\n");
                else sb.append(q.poll()+"\n");
            }else{
                q.add(x);
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
