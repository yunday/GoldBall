import java.util.*;
import java.util.Map.*;

class Solution {
    static int[] arr;
    static int len;
    static int answer;
    public int solution(String[][] clothes) {
        answer = 1;
        
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for(int i=0;i<clothes.length;i++){
            if(h.containsKey(clothes[i][1])) h.put(clothes[i][1], h.get(clothes[i][1])+1);
            else h.put(clothes[i][1], 1);
        }
        len = h.size();
        arr = new int[len];
        int j=0;
        for(Entry<String, Integer> entry : h.entrySet()){
            arr[j++] = entry.getValue();
        }
        
        for(int i=0;i<len;i++){
            answer *= (arr[i]+1);
        }
        
        return answer-1;
    }
}
