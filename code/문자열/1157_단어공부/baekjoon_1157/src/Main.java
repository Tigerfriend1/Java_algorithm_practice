import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        str=str.toUpperCase();
        int[] count = new int[26];
        for (int i=0; i<str.length();i++){
            count[str.charAt(i)-'A']++;
        }
        int max_count=-1;
        char max='?';
        for (int i=0; i<26;i++){
            if (count[i]>max_count){
                max_count=count[i];
                max=(char)('A'+i);
            } else if (count[i]==max_count) {
                max='?';

            }
        }
        System.out.println(max);

    }
}