import java.util.*;

class Solution {
    static int[] arr;
    static int answer;
    public int solution(String numbers) {
        answer = 0;
        arr = new int[10];

        for(int i=0;i<numbers.length();i++){
            int k = numbers.charAt(i)-'0';
            arr[k] += 1;
        }

        for(int i=1;i<=numbers.length();i++){
            dfs(0, i, 0);
        }

        return answer;
    }

    public static void dfs(int idx, int target, int tNum){
        if(idx==target){
            if(isPrime(tNum)){
                answer += 1;
            }
            return;
        }

        for(int i=0;i<10;i++){
            if(idx==0&&i==0) continue;
            if(arr[i]>0){
                arr[i]-=1;
                dfs(idx+1, target, tNum*10+i);
                arr[i]+=1;
            }
        }
    }

    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        if(n==1) return false;
        return true;
    }
}
