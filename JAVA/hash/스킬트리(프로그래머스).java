import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int n = skill_trees.length;
        int skill_n = skill.length();
        int[] arr;
        HashMap<Character, Integer> index = new HashMap<>();
        for(int i=0;i<skill_n;i++){
            index.put(skill.charAt(i), i);
        }

        for(int i=0;i<n;i++){
            String s = skill_trees[i];
            arr = new int[skill_n];
            int cnt = 0;
            for(int j=0;j<s.length();j++){
                if(index.containsKey(s.charAt(j))){
                    arr[index.get(s.charAt(j))] = j+1;
                    cnt = Math.max(cnt, index.get(s.charAt(j)));
                } 
            }
            
            boolean state = false;
            for(int j=0;j<cnt;j++){
                if((j<cnt&&arr[j]==0)||arr[j]>arr[j+1]){
                    state = true;
                    break;
                }
            }
            if(!state) answer += 1;
        }
        
        return answer;
    }
}
