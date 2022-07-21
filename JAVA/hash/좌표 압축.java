import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        int[] answer = new int[n];
        
        String[] tmp1 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp1[i]);
            arr2[i] = Integer.parseInt(tmp1[i]);
        }
        
        Arrays.sort(arr);
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> h2 = new HashMap<Integer, Integer>();
        int k=0;
        for(int i=0;i<n;i++){
            if(h.containsKey(arr[i])) h.put(arr[i], h.get(arr[i])+1);
            else h.put(arr[i], 1);
            if(!h2.containsKey(arr[i])) h2.put(arr[i], k++);
        }
        
        for(int i=0;i<n;i++){
            h.put(arr2[i], h.get(arr2[i])-1);
            answer[i] = h2.get(arr2[i]);
        }
        for(int i=0;i<n-1;i++){
            sb.append(String.valueOf(answer[i])).append(" ");
        }
        sb.append(String.valueOf(answer[n-1]));
        System.out.println(sb);
    }
}
