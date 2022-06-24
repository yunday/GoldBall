// 크기가 아주 큰 (백만) 경우는 br bw 꼭 이용하고. 지금 연결리스트는 삭제 추가 함수가 너무 오래걸린다
// 대신 스택을 두개 쓰면 시간은 줄고 메모리는 두배가 된다.

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            String str = br.readLine();
            LinkedList<Character> s = new LinkedList<>();
            int idx = 0;
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0'&&c<='9')){
                    s.add(idx, str.charAt(j));
                    idx+=1;
                }
                if(c == '<' && idx!=0) {
                    idx -= 1;
                }
                else if(c == '>' && idx!=s.size()) {
                    idx +=1;
                }
                if(c == '-' && idx-1 != -1){
                    s.remove(idx-1);
                    idx-=1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char data : s){
                sb.append(data);
            }
            System.out.println(sb);
        }   
        bw.flush();
        bw.close();
    }
}
