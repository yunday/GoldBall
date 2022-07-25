// 1~10배수 공식이 있고, 30배수 공식도 따로 있음. 배수 공식을 잘 이용하자

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String s = br.readLine();
        int n = s.length();
        int[] arr = new int[n];
        
        int sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = s.charAt(i)-'0';
            sum += arr[i];
        }
        Arrays.sort(arr);
        if(arr[0]!=0||sum%3!=0) System.out.println(-1);
        else{
            for(int j=n-1;j>-1;j--) sb.append(arr[j]);
            System.out.println(sb);
        }
    }
}
