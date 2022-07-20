import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> lst = new HashMap<String, Integer>();
        for(String s :phone_book) lst.put(s, 1);
        for(String s :phone_book){
            for(int i=1;i<s.length();i++){
                String k = s.substring(0, i);
                if(lst.containsKey(k)){
                    return false;
                }
            }
        }
        
        return answer;
    }
}
