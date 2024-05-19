import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph=new ArrayList[N+1]; //배열 크기 확인
        for(int i=1;i<N+1;i++){
            graph[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        dp=new int[N+1][2];
        visited = new boolean[N+1];
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));

    }
    static public void dfs(int value){
        visited[value]=true;
        dp[value][0]=0;
        dp[value][1]=1;
        for(int child : graph[value]){
            if(!visited[child]){
                dfs(child);
                dp[value][0]+=dp[child][1];
                dp[value][1]+=Math.min(dp[child][0],dp[child][1]);
            }
        }
    
    

    }
}
