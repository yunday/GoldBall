import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        int n = Integer.parseInt(tmp1[0]);
        int m = Integer.parseInt(tmp1[1]);
        ArrayList<String> arr = new ArrayList<String>();
        
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for(int i=0;i<n;i++) h.put(br.readLine(), 1);
        for(int i=0;i<m;i++){
            String s = br.readLine();
            if(h.containsKey(s)) arr.add(s);
        }
        
        System.out.println(arr.size());
        Collections.sort(arr);
        for(String s : arr) System.out.println(s);
    }
}
