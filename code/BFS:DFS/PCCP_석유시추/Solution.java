import java.util.*;
class Solution {
    boolean visited[][];
    int[][] land;
    int jmap[];
    int N,M;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public void bfs(int i, int j){
        //System.out.println("i,j=" + i+","+j);
        HashSet<Integer> nowidx = new HashSet<>();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{i,j});
        visited[i][j]=true;
        int blockSum=1; //i,j포함 1
        nowidx.add(j);//석유블록이 있는 j좌표
        while(!dq.isEmpty()){
            int[] now=dq.poll();
            //System.out.println("ni,nj=" + now[0]+","+now[1]);
            for(int k=0;k<4;k++){
                int nx = now[0]+dx[k];
                int ny = now[1]+dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && land[nx][ny]==1){
                    visited[nx][ny]=true;
                    blockSum++;
                    nowidx.add(ny);
                    dq.offer(new int[]{nx,ny});
                    //System.out.println("nx,ny=" + nx+","+ny);
                }
            }
        }
        //System.out.println("nowidx=" + nowidx);
        //해당 석유값을 지나간 j위치별로 더해줌.
        for(int idx : nowidx){
            jmap[idx]+= blockSum;//석유블록값
        }
        //System.out.println(Arrays.toString(jmap));
    }
    
    public int solution(int[][] land) {
        this.land=land;
        N=land.length;
        M=land[0].length;
        visited=new boolean[N][M];
        jmap=new int[M];
        int answer = 0;
        
        for(int j=0;j<M;j++){
            for(int i=0;i<N;i++){
                if(land[i][j]==0 || visited[i][j]){ //석유가 없거나 이미 방문했으면 패스
                    continue;
                }
                bfs(i,j); //해당 석유블록량을 시추관 j위치별 모두 더해줌.
                
            }
        }
        Arrays.sort(jmap);
        return jmap[jmap.length-1];
    }
}