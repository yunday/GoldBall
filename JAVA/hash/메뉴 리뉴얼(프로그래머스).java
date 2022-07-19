import java.util.*;
import java.util.Map.*;

class Solution {
    static String arr="";
    static ArrayList<String> ans;
    static int maxValue;
    public String[] solution(String[] orders, int[] course) {
        ans = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }
        for(int i=0;i<course.length;i++){
            HashMap<String, Integer> h = new HashMap<>();
            maxValue = 0;
            for(int j=0;j<orders.length;j++){
                dfs(orders[j], 0, course[i], h, -1);
            }
            for(Entry<String, Integer> entry: h.entrySet()){
                String key = entry.getKey();
                int value = entry.getValue();
                if(maxValue==value){
                    ans.add(key);
                }
            }
        }
        String[] answer = ans.toArray(new String[ans.size()]);
        Arrays.sort(answer);
        return answer;
    }
    
    public static void dfs(String s, int idx, int max, HashMap<String, Integer> h, int last){
        if(idx==max){
            if(h.containsKey(arr)){
                h.put(arr, h.get(arr)+1);
                if(h.get(arr)>maxValue) maxValue = h.get(arr);
            }else{
                h.put(arr, 1);
            }
            return;
        }
        
        for(int i=last+1;i<s.length();i++){
            arr += s.charAt(i);
            dfs(s, idx+1, max, h, i);
            arr = arr.substring(0, arr.length()-1);
        }
    }
}
