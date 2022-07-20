import java.util.*;

class Solution
{
    public int solution(String s)
    {
        //stack
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()) stack.add(s.charAt(i));
            else{
                char tmp = stack.pop();
                if(tmp!=s.charAt(i)){
                    stack.add(tmp);
                    stack.add(s.charAt(i));
                } 
            }

        }
        if(stack.isEmpty()) return 1;
        return 0;
        
    }
}
