// 14분

import java.util.*;
import java.util.Map.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> lst = new HashMap<String, Integer>();
        for(int i=0;i<participant.length;i++){
            if(lst.containsKey(participant[i])) lst.put(participant[i], lst.get(participant[i])+1);
            else lst.put(participant[i], 1);
        }
        for(int i=0;i<completion.length;i++){
            lst.put(completion[i], lst.get(completion[i])-1);
        }
        for(Entry<String, Integer> entry : lst.entrySet()){
            if(entry.getValue()>0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}
