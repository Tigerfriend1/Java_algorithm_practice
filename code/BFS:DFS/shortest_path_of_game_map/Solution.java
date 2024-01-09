import java.util.*;
class Solution {
    int[][] maps;
    int answer = -1;
    boolean[][] visited;
    int h,w;
    int[] dx={1,-1,0,0};
    int[] dy={0,0,-1,1};
    public int solution(int[][] maps) {
        this.maps=maps;
        h=maps.length;
        w=maps[0].length;
        visited=new boolean[h][w];
        Queue<Node> q=new LinkedList<>();
        visited[0][0]=true;
        q.offer(new Node(0,0,1));
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.x==h-1 &&node.y==w-1){
                System.out.println(answer+"  "+node.dist);
                answer=node.dist; //먼저 도착하는 곳이 최단거리.
                break; //찾았으니 탈출
            }
            for(int i=0; i<4;i++){
                int nx=node.x+dx[i];
                int ny=node.y+dy[i];
                if(nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    q.offer(new Node(nx,ny,node.dist+1));
                }
            }
        }
        return answer;
    }
    public static class Node{
        int x;
        int y;
        int dist;

        Node(int x, int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

}