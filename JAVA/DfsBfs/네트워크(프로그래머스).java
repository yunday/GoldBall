// 11분

class Solution {
    static boolean[] b;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        b = new boolean[n];
        for(int i=0;i<n;i++){
            if(!b[i]){
                dfs(i, computers, n);
                answer += 1;
            }
        }
            
        return answer;
    }
    
    public static void dfs(int idx, int[][] computers, int n){
        for(int i=0;i<n;i++){
            if(i==idx) continue;
            if(computers[idx][i]==1&&!b[i]){
                b[i] = true;
                dfs(i, computers, n);
            }
        }
    }
}
