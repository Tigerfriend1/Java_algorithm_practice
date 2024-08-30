import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main{
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i]=Integer.parseInt(br.readLine());
            
        }
        Arrays.sort(coins);
        int[] dp=new int[10001];
        dp[0]=1;
        for(int coin : coins){
            for(int i=coin;i<k+1;i++){ //0~10까지 11번반복
                dp[i]+=dp[i-coin];

            }
        }
        System.out.println(dp[k]);


    }
}