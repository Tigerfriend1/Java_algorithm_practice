import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int count=0;
        int idx=-1;
        for (int i=0; i<str1.length();i++){
            idx=str1.indexOf(str2,i);
            if (idx!=-1){
                count++;
                i=idx+str2.length()-1;
            }
        }
        System.out.println(count);
    }
}