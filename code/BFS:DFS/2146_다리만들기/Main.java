import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int N;
    static ArrayDeque<Node> q = new ArrayDeque<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    public static class Node{
        int i;
        int j;
        //int value;
        int d;
        Node(int i, int j, int d){
            this.i=i;
            this.j=j;
            //this.value=value;
            this.d=d;
        }

    }
    static public void idxLand(){
        visited = new boolean[N][N];
        int idx = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && map[i][j]!=0){ //방문x와 섬일때
                    map[i][j]=idx;//해당 섬라인을 idx매김. 여기서 매기기.
                    visited[i][j]=true;
                    q.offer(new Node(i,j,0)); 
                    while(!q.isEmpty()){
                        Node pos = q.poll();
                        //node[pos.i][pos.j].value=idx; //해당 섬라인을 idx매김.
                        for(int k = 0; k<4;k++){
                            int nx = pos.i+dx[k];
                            int ny = pos.j+dy[k];
                            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                            if(visited[nx][ny]) continue;
                            if(map[nx][ny]==1){
                                visited[nx][ny]=true;
                                map[nx][ny]=idx;
                                q.offer(new Node(nx,ny,0));

                            }
                        }

                    }
                    idx++;
                }
                
            }
        }

    }
    static public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        //node = new Node[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                //node[i][j] = new Node(i,j,value,0);
            }
        }
        idxLand();
        //섬번호 매긴 후 bfs를 하면서 최단거리찾음.
        int mind = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]>0){
                    int d = find(i,j);
                    if(d==-1) continue;
                    mind = Math.min(mind,d);
                }
                

            }
        }
        System.out.println(mind-1);



    }
    static int find(int i, int j){ //주어진 좌표와 같은 섬은 찾지 않는다.
        int idx = map[i][j];
        visited = new boolean[N][N];
        q=new ArrayDeque<>();
        q.offer(new Node(i,j,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            //다른 섬이면 return
            if(map[now.i][now.j]!=0 && map[now.i][now.j]!=idx) return now.d;
            for(int k=0;k<4;k++){
                int nx = now.i+dx[k];
                int ny = now.j+dy[k];
                // 좌표 벗어나면 x
                // 방문했거나 같은 섬이면 x
                // 아니면 거리 +1해서 q에 넣기
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(visited[nx][ny] || map[nx][ny]==idx) continue;

                visited[nx][ny]=true;
                q.offer(new Node(nx,ny,now.d+1));
                    
                
            }
        }
        return -1; //갈수없는섬.


    }
}

