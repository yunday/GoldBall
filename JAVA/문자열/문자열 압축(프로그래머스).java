class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1;i<=(int)(s.length()/2);i++){
            boolean state = false;
            int cnt = 0;
            int cnt2 = 1;
            for(int j=0;j<s.length()-i-s.length()%i;j+=i){
                if(s.substring(j, j+i).equals(s.substring(j+i, j+2*i))){
                    cnt2++;
                }else{
                    if(cnt2>1){
                        cnt += i+String.valueOf(cnt2).length();
                        cnt2=1;
                    }else{
                        cnt += i;
                    }
                }
            }
            if(cnt2>1){
                cnt+= i+String.valueOf(cnt2).length()+s.length()%i;
            }else cnt += i+s.length()%i;
            if(cnt<answer) answer = cnt;
        }
        
        return answer;
    }
}
