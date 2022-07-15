import java.util.*;
import java.io.*;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String tmp1 = br.readLine();
            char[] func = tmp1.toCharArray();
            
            int n = Integer.parseInt(br.readLine());
            
            boolean state = false;
            Deque<Integer> arr = new LinkedList<Integer>();
            String tmp2 = br.readLine();
            if(n>0){
                tmp2 = tmp2.substring(1, tmp2.length()-1);
                String[] tmp3 = tmp2.split(",");
                for(int j=0;j<tmp3.length;j++) arr.add(Integer.parseInt(tmp3[j]));
            }

            int cnt = 0;
            for(int j=0;j<func.length;j++){
                if(func[j]=='R') cnt++;
                else{
                    if(arr.isEmpty()){
                        System.out.println("error");
                        state = true;
                        break;
                    }
                    if(cnt%2==1) arr.removeLast();
                    else arr.removeFirst();
                }
            }
            if(!state){
                StringBuilder sb = new StringBuilder("[");
                while(!arr.isEmpty()){
                    sb.append(cnt%2==1 ? arr.removeLast():arr.removeFirst());
                    if(arr.size()!=0) sb.append(',');
                }
                sb.append("]");

                System.out.println(sb.toString());   
            }
        }

    }
}
