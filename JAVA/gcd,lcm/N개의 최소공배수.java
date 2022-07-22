import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        Arrays.sort(arr);
        int i=2;
        while(true){
            int cnt = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]%i==0){
                    arr[j]/=i;
                }else cnt++;
            }
            if(cnt==arr.length){
                i++;
                continue;
            }else answer *= i;
                
            boolean state = false;
            for(int j:arr){
                if(j!=1) state = true;
            }
            if(!state) break;
        }
        
        return answer;
    }
}
