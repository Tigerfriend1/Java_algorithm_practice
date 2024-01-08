import java.util.*;
class Solution {
    int answer = 0;
    int n;
    int[][] computers;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        this.n=n;
        this.computers=computers;
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
    public void dfs(int x){

        visited[x]=true;

        for(int i=0; i<n;i++){
            if(computers[x][i]==1 && visited[i]==false){
                dfs(i);
            }
        }
    }
}