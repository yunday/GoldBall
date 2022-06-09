import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> m = new HashMap<String, Integer>();
            for(int j=0;j<n;j++){
                String[] s = br.readLine().split(" ");
                if(m.containsKey(s[1])){
                    m.put(s[1], m.get(s[1])+1);
                }else{
                    m.put(s[1], 1);
                }
            }
            int result = 1;
            for(String key:m.keySet()){
                result *= (m.get(key)+1);
            }
            System.out.println(result-1);
        }
    }
}

/* hashmap을 이용해 개수 세기 */
