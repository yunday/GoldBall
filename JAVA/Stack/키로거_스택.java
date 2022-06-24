import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            String str = br.readLine();
            Stack<Character> s1 = new Stack<>();
            Stack<Character> s2 = new Stack<>();
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9')){
                    s1.push(str.charAt(j));
                    continue;
                }
                if(c == '<' && !s1.isEmpty()) {
                    s2.push(s1.pop());
                    continue;
                }
                if(c == '>' && !s2.isEmpty()) {
                    s1.push(s2.pop());
                    continue;
                }
                if(c == '-' && !s1.isEmpty()){
                    s1.pop();
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
                for(int k=0;k<s1.size();k++){
                    sb.append(s1.elementAt(k));
                }
                System.out.println(sb);
            }
            

        }   
        bw.flush();
        bw.close();
    }
}
