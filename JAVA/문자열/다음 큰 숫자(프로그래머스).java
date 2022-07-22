import java.util.*;

class Solution {
    public int solution(int n) {
        String s = Integer.toBinaryString(n);
        int[] arr = new int[s.length()+1];
        arr[0] = 0;
        int cnt = 0;
        for(int i=1;i<=s.length();i++){
            arr[i] = s.charAt(i-1)-'0';
            if(arr[i]==1) cnt++;
        } 
        
        for(int i=n+1;i<=1000000;i++){
            String s2 = Integer.toBinaryString(i);
            int cnt2 = 0;
            for(int j=0;j<s2.length();j++){
                if(s2.charAt(j)=='1') cnt2++;
            }
            if(cnt==cnt2) return i;
        }
        return 0;
    }
}

// Integer.toBinaryString(i) 로 이진수 만들고
// 때로는 브루트포스같은게 더 빠를 수 있다..... 괜히 이상한 공식 만들어서 풀지말자 ㅜㅠ
