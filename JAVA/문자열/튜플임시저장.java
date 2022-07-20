class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.substring(1, s.length()-1);
        String[] tmp1 = s.split("\\{|\\}");
        String[] tmp2 = new String[tmp1.length/2];
        for(int i=0;i<tmp1.length/2;i++){
            tmp2[i]=tmp1[i*2+1];
        }
        int n = tmp2.length;
        
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            String[] tmp3 = tmp2[i].split(",");
        }
        for(int i=0;i<n;i++) 
            System.out.println(tmp3[i]);
        
        return answer;
    }
}
