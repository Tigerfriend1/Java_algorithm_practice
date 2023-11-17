import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] chars = st.nextToken().toCharArray();


        for (int i = 0; i<chars.length; i++){
            if ('a'<=chars[i]&& chars[i]<='z'){
                chars[i]=(char) ('A'+chars[i]-'a');

            }else{
                chars[i]= (char) ('a'+chars[i]-'A');
            }
        }
        System.out.println(chars);
    }
}