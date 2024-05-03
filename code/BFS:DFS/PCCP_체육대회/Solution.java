import java.util.*;
class Solution {
    
    int answer = 0;
    public void perm(int[][] ability, int depth, boolean[] visited, int sum, int n, int r){
        if(depth==r){//ex)r==3
            answer=Math.max(answer,sum);
            return;
        }
        for(int i=0;i<n;i++){//r이 증가함에 따라 다른걸 골라야함.depth로 판별
            if(!visited[i]){
                visited[i]=true;
                sum+=ability[i][depth];
                perm(ability,depth+1,visited,sum,n,r);
                sum-=ability[i][depth];
                visited[i]=false;
            }
        }
    }
    public int solution(int[][] ability) {
        
        int stulen=ability.length;
        int playlen=ability[0].length;
        boolean[] visited=new boolean[stulen];
        perm(ability,0,visited,0,stulen,playlen);
        
        return answer;
    }
}