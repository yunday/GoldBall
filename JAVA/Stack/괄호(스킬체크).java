import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a==')'&&!stack.isEmpty()){
                stack.pop();
            }else if(a=='('){
                stack.add(a);
            }else return false;
        }
        if(!stack.isEmpty()) return false;

        return answer;
    }
}
