import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] tmp1 = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(tmp1, (a, b)->{return a.length() - b.length();});
        
        int n = tmp1.length;
        HashMap<String, Integer> h = new HashMap<>();
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            String[] tmp3 = tmp1[i].split(",");
            for(int j=0;j<tmp3.length;j++){
                if(!h.containsKey(tmp3[j])){
                    h.put(tmp3[j], 1);
                    answer[i]=Integer.parseInt(tmp3[j]);
                }
            }
        }
        
        return answer;
    }
}
