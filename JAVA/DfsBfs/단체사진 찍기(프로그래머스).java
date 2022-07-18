class Solution {
    static int cnt, N;
    static boolean[] dataB;
    static String[] Data;
    static int[] nowData;
    static char[] word = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        int answer = 0;
        cnt = 0;
        N = n;
        Data = data;
        dataB = new boolean[8];
        nowData = new int[8];
        dfs(0);
        answer = cnt;
        return answer;
    }
    
    public static void dfs(int idx){
        if(idx==8){
            if(check()) cnt++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(!dataB[i]){
                dataB[i] = true;
                nowData[i] = idx;
                dfs(idx+1);
                dataB[i] = false;
            }
        }
    }
    
    public static boolean check(){
        for(int i=0;i<N;i++){
            String s = Data[i];
            int a=0;
            int b=0;
            
            for(int j=0;j<8;j++){
                if(s.charAt(0)==word[j]) a = nowData[j];
                if(s.charAt(2)==word[j]) b = nowData[j];
            }
            String z = ""+s.charAt(4);
            int c = Integer.parseInt(z)+1;
            
            if(s.charAt(3)=='='){
                if(Math.abs(a-b)!=c) return false;
            }else if(s.charAt(3)=='>'){
                if(Math.abs(a-b)<=c) return false;
            }else{
                if(Math.abs(a-b)>=c) return false;
            }
        }
        return true;
    }
}
