import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = citations[i];
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(arr[i]>=i+1){
                answer = i+1;
            }else break;
        }
        
        return answer;
    }
}
