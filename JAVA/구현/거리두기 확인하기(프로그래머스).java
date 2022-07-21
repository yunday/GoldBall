import java.util.*;

class Solution {
    static char[][] cArray;
    static int n;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1, -2, 0, 2, 0};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1, 0, 2, 0, -2};
    public int[] solution(String[][] places) {
        n = 5;
        int[] answer = new int[n];
        for(int t=0;t<n;t++){
            cArray = new char[n][n];
            Queue<int[]> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    cArray[i][j] = places[t][i].charAt(j);
                    if(places[t][i].charAt(j)=='P') q.add(new int[] {i, j});
                }
            }
            boolean state = false;
            while(!q.isEmpty()){
                int[] mp = q.poll();
                if(!find(mp[0], mp[1])){
                    answer[t] = 0;
                    state=true;
                    break;
                }
            }
            if(!state) answer[t] = 1;
        }
        
        return answer;
    }
    
    public static boolean find(int x, int y){
        // 1. 맨해튼거리 2보다 크면 return true;
        // 2. 맨해튼거리 2보다 작거나 같은놈 중에서 칸막이 여부
        
        for(int i=0;i<12;i++){
            if(x+dx[i]<0||x+dx[i]>=n||y+dy[i]<0||y+dy[i]>=n) continue;
            if(cArray[x+dx[i]][y+dy[i]] == 'P'){
                if(i/4==0){
                    return false;
                }else if(i/4==1){
                    if(cArray[x+dx[(i-1)%4]][y+dy[(i-1)%4]]!='X'||cArray[x+dx[i%4]][y+dy[i%4]]!='X') return false;
                }else{
                    if(cArray[x+dx[i%4]][y+dy[i%4]]!='X') return false;
                }
            }
        }
        return true;
    }

}
