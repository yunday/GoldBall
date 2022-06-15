import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String s = br.readLine()+"\n";
            Stack<Character> stack = new Stack<>();
            int k=0;
            StringBuilder sb = new StringBuilder();
            while(k<s.length()){
                if(s.charAt(k) != ' ' && s.charAt(k) != '\n'){
                    stack.add(s.charAt(k));
                }else{
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());                       
                    }
                    sb.append(" ");
                }
                k++;
            }
            System.out.println(sb);
        }
    }
}
