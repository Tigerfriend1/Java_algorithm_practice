import java.io.*;
import java.util.*;

public class Main {
    public static int[] myCount(String str){
        int[] count=new int[26];
        for(int i=0; i<str.length();i++){
            count[str.charAt(i)-'a']++;

        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String str1 = st1.nextToken();
        String str2 = st2.nextToken();

        int[] count1 = myCount(str1);
        int[] count2 = myCount(str2);
        int answer=0;
        for (int i = 0;i<26 ;i++){
            answer+=Math.abs(count1[i]-count2[i]);
        }
        System.out.println(answer);


    }
}